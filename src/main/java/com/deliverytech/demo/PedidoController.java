package com.deliverytech.demo;

import java.math.BigDecimal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {
    private static final BigDecimal PRECO = new BigDecimal("25.00");

    public record Pedido(int quantidade) {}
    public record Resultado(int quantidade, BigDecimal valorUnitario, BigDecimal valorTotal) {}
    public record Erro(String mensagem) {}

    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("OK");
    }

    @PostMapping("/calcular")
    public ResponseEntity<?> calcular(@RequestBody Pedido pedido) {
        int quantidade = pedido.quantidade();
        if (quantidade < 1 || quantidade > 20) {
            return ResponseEntity.badRequest().body(new Erro("A quantidade deve estar entre 1 e 20."));
        }
        BigDecimal total = PRECO.multiply(BigDecimal.valueOf(quantidade));
        return ResponseEntity.ok(new Resultado(quantidade, PRECO, total));
    }
}
