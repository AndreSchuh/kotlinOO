
// Importando todas as classes necessárias dos outros pacotes
import entity.ItemMenu
import entity.Pedido
import restaurante.staff.Cozinheiro
import restaurante.staff.Funcionario
import restaurante.staff.Garcom
import restaurante.exception.PedidoVazioException

/**
 * Ponto de entrada principal da aplicação.
 * Este arquivo orquestra a criação de objetos e a simulação do fluxo do restaurante.
 */
fun main() {
    println("--- Sistema de Gerenciamento de Restaurante ---")

    // 1. INSTÂNCIAS (CRIAÇÃO DE OBJETOS)
    println("\n1. Criando instâncias dos funcionários e itens do menu...")
    val chefPrincipal = Cozinheiro("Ana Silva", 4500.0, "Culinária Italiana")
    val garcomJoao = Garcom("João Costa", 2800.0, "Varanda")
    val pratoPrincipal = ItemMenu("Spaghetti Carbonara", 55.0)
    val sobremesa = ItemMenu("Tiramisu", 25.0)

    println(" -> Cozinheiro criado: ${chefPrincipal.nome}")
    println(" -> Garçom criado: ${garcomJoao.nome}")

    // 2. DEMONSTRAÇÃO DE HERANÇA E POLIMORFISMO
    println("\n2. Demonstrando Herança e Polimorfismo...")
    val equipe: List<Funcionario> = listOf(chefPrincipal, garcomJoao)
    for (funcionario in equipe) {
        funcionario.trabalhar()
    }

    // 3. SIMULAÇÃO DO FLUXO
    println("\n3. Simulando o fluxo de um pedido...")
    val pedidoCompleto = garcomJoao.anotarPedido(listOf(pratoPrincipal, sobremesa))
    println(" -> Pedido criado: $pedidoCompleto")

    // 4. TRATAMENTO DE EXCEÇÕES
    println("\n4. Demonstrando Tratamento de Exceções...")

    // Tentativa 1: Pedido válido
    try {
        println("\nTentando preparar o pedido completo...")
        chefPrincipal.prepararPedido(pedidoCompleto)
        println("SUCESSO: Pedido preparado sem erros.")
    } catch (e: PedidoVazioException) {
        println("ERRO CAPTURADO: ${e.message}")
    }

    // Tentativa 2: Pedido inválido
    val pedidoVazio = Pedido(emptyList())
    try {
        println("\nTentando preparar um pedido vazio...")
        chefPrincipal.prepararPedido(pedidoVazio)
    } catch (e: PedidoVazioException) {
        println("ERRO CAPTURADO: ${e.message}")
    } finally {
        println("Bloco 'finally': esta mensagem sempre aparece ao final da tentativa de preparo.")
    }

    println("\n--- Fim da Demonstração ---")
}