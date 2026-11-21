package com.merida.tecnm.market_backend_v3.web.controller;

import com.merida.tecnm.market_backend_v3.domain.Purchase;
import com.merida.tecnm.market_backend_v3.domain.service.PurchaseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchases")
@Tag(name = "Purchase", description = "Transactional operations for purchases")
public class PurchaseController {

    private final PurchaseService purchaseService;

    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @GetMapping("")
    @Operation(
            summary = "Get all purchases",
            description = "Return a list of all purchases made"
    )
    @ApiResponse(responseCode = "200", description = "Successful retrieval of purchases")
    @ApiResponse(responseCode = "500", description = "Internal server error")
    public ResponseEntity<List<Purchase>> getAll() {
        return new ResponseEntity<>(purchaseService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/client/{clientId}")
    @Operation(
            summary = "Get purchases by client ID",
            description = "Return all purchases made by a specific client"
    )
    @ApiResponse(responseCode = "200", description = "Purchases found for client")
    @ApiResponse(responseCode = "404", description = "No purchases found for client")
    @ApiResponse(responseCode = "500", description = "Internal server error")
    public ResponseEntity<List<Purchase>> getByClient(
            @Parameter(
                    description = "ID of the client whose purchases are requested",
                    example = "CLI-001",
                    required = true
            )
            @PathVariable("clientId") String clientId) {

        return purchaseService.getByClient(clientId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("")
    @Operation(
            summary = "Save a purchase with items (Master-Detail)",
            description = "Process a complex purchase DTO and persist header and details in a single transaction with cascade",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    content = @Content(
                            examples = @ExampleObject(
                                    name = "Supermarket Ticket Example",
                                    value = """
                                            {
                                              "clientId": "4546221",
                                              "paymentMethod": "E",
                                              "comment": "Entregar por la tarde",
                                              "state": "P",
                                              "items": [
                                                {
                                                  "productId": 1,
                                                  "quantity": 2,
                                                  "total": 600.0,
                                                  "active": true
                                                }
                                              ]
                                            }
                                            """
                            )
                    )
            )
    )
    @ApiResponse(responseCode = "201", description = "Purchase created successfully")
    @ApiResponse(responseCode = "400", description = "Invalid purchase data")
    @ApiResponse(responseCode = "500", description = "Internal server error")
    public ResponseEntity<Purchase> save(@RequestBody Purchase purchase) {
        return new ResponseEntity<>(purchaseService.save(purchase), HttpStatus.CREATED);
    }
}
