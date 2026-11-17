# Kotlin OO: Sistema de Restaurante

Simulação de um restaurante em **Kotlin** para praticar orientação a objetos.

## Conceitos praticados
- Classes e instâncias (`ItemMenu`, `Pedido`)
- Herança e polimorfismo (`Funcionario` → `Cozinheiro`, `Garcom`)
- Fluxo de pedido: o garçom anota e o cozinheiro prepara
- Exceções personalizadas (`PedidoVazioException`)

## Estrutura
```
src/main/restaurante/
├── Main.kt                      # orquestra a simulação
├── entity/ItemMenu.kt, Pedido.kt
├── staff/Funcionario.kt
└── exception/PedidoVazioException.kt
```

## Tecnologias
Kotlin · Maven

## Como rodar
Abra no IntelliJ IDEA e execute `Main.kt`.
