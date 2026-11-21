package com.merida.tecnm.market_backend_v3.web.dto.mapper;

import com.merida.tecnm.market_backend_v3.domain.Purchase;
import com.merida.tecnm.market_backend_v3.domain.PurchaseItem;
import com.merida.tecnm.market_backend_v3.web.dto.PurchaseItemDto;
import com.merida.tecnm.market_backend_v3.web.dto.PurchaseRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface PurchaseDtoMapper {

    @Mappings({
            @Mapping(source = "idCliente", target = "clientId"),
            @Mapping(source = "medioPago", target = "paymentMethod"),
            @Mapping(source = "comentario", target = "comment"),
            @Mapping(source = "productosAdquiridos", target = "items"),
            @Mapping(target = "purchaseId", ignore = true),
            @Mapping(target = "date", ignore = true),
            @Mapping(target = "state", ignore = true)
    })
    Purchase toPurchase(PurchaseRequestDto dto);

    @Mappings({
            @Mapping(source = "idProducto", target = "productId"),
            @Mapping(source = "cantidad", target = "quantity"),
            @Mapping(source = "total", target = "total"),
            @Mapping(target = "active", constant = "true")
    })
    PurchaseItem toPurchaseItem(PurchaseItemDto dto);
}
