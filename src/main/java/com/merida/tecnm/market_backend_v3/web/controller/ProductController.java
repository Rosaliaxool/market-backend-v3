package com.merida.tecnm.market_backend_v3.web.controller;

import com.merida.tecnm.market_backend_v3.domain.Product;
import com.merida.tecnm.market_backend_v3.domain.service.ProductService;

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
@RequestMapping("/products")
@Tag(name = "Product", description = "Manage your products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("")
    @Operation(
            summary = "Get all products",
            description = "Return a list of all available products"
    )
    @ApiResponse(responseCode = "200",
            description = "Successful retrieval of products")
    @ApiResponse(responseCode = "500",
            description = "Internal server error")
    public ResponseEntity<List<Product>> getAll() {
        return new ResponseEntity<>(
                productService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Get product by ID",
            description = "Return a product by its ID if it exists"
    )
    @ApiResponse(responseCode = "200",
            description = "Product found")
    @ApiResponse(responseCode = "404",
            description = "Product not found")
    @ApiResponse(responseCode = "500",
            description = "Internal server error")
    public ResponseEntity<Product> getProduct(
            @Parameter(
                    description = "ID of the product to be retrieved",
                    example = "7",
                    required = true
            )
            @PathVariable("id") int productId) {

        return productService.getProduct(productId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/category/{categoryId}")
    @Operation(
            summary = "Get products by category",
            description = "Return all products in a specific category"
    )
    @ApiResponse(responseCode = "200",
            description = "Product(s) found in the category")
    @ApiResponse(responseCode = "404",
            description = "Product(s) not found in the category")
    @ApiResponse(responseCode = "500",
            description = "Internal server error")
    public ResponseEntity<List<Product>> getByCategory(
            @Parameter(
                    description = "Category ID",
                    example = "7",
                    required = true
            )
            @PathVariable("categoryId") int categoryId) {

        return productService.getByCategory(categoryId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("")
    @Operation(
            summary = "Create a new product",
            description = "Register a new product and return it",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    content = @Content(
                            examples = @ExampleObject(
                                    name = "Example Product",
                                    // Ajusta estos campos a los de tu clase Product
                                    value = """
                                            {
                                                "name": "Helado",
                                                "categoryId": 5,
                                                "price": 19.50,
                                                "stock": 300,
                                                "active": true
                                            }
                                            """
                            )
                    )
            )
    )
    @ApiResponse(responseCode = "201",
            description = "Product created successfully")
    @ApiResponse(responseCode = "400",
            description = "Invalid product data")
    @ApiResponse(responseCode = "409",
            description = "Product conflict (duplicate code or SKU)")
    @ApiResponse(responseCode = "500",
            description = "Internal server error")
    public ResponseEntity<Product> save(@RequestBody Product product) {
        return new ResponseEntity<>(
                productService.save(product),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Update an existing product",
            description = "Update product data by its ID and return the updated product",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    content = @Content(
                            examples = @ExampleObject(
                                    name = "Example Updated Product",
                                    value = """
                                            {
                                                "name": "Helado Artesanal",
                                                "categoryId": 5,
                                                "price": 25.00,
                                                "stock": 150,
                                                "active": true
                                            }
                                            """
                            )
                    )
            )
    )
    @ApiResponse(responseCode = "200",
            description = "Product updated successfully")
    @ApiResponse(responseCode = "400",
            description = "Invalid product data")
    @ApiResponse(responseCode = "404",
            description = "Product not found")
    @ApiResponse(responseCode = "500",
            description = "Internal server error")
    public ResponseEntity<Product> update(
            @Parameter(
                    description = "ID of the product to update",
                    example = "7",
                    required = true
            )
            @PathVariable("id") int productId,
            @RequestBody Product product) {

        return productService.update(productId, product)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Delete a product by ID",
            description = "Deletes a product if it exists"
    )
    @ApiResponse(responseCode = "204",
            description = "Product deleted successfully")
    @ApiResponse(responseCode = "400",
            description = "Invalid product ID")
    @ApiResponse(responseCode = "404",
            description = "Product not found")
    @ApiResponse(responseCode = "500",
            description = "Internal server error")
    public ResponseEntity<Void> delete(
            @Parameter(
                    description = "ID of the product to be deleted",
                    example = "7",
                    required = true
            )
            @PathVariable("id") int productId) {

        if (productService.delete(productId)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}