package restaurante.staff

// Importações necessárias de outros pacotes
import entity.Pedido
import restaurante.exception.PedidoVazioException

/**
 * Arquivo que define a hierarquia de funcionários do restaurante.
 * Demonstra Herança e Polimorfismo.
 */

// CLASSE BASE (aberta para herança)
open class Funcionario(val nome: String, val salario: Double) {
    open fun trabalhar() {
        println("O funcionário $nome está realizando suas tarefas gerais.")
    }

    override fun toString(): String {
        return "Funcionário(nome='$nome', salario=$salario)"
    }
}

// CLASSE DERIVADA 1
class Cozinheiro(nome: String, salario: Double, val especialidade: String) : Funcionario(nome, salario) {
    // Sobrescrita do método (Polimorfismo)
    override fun trabalhar() {
        println("O cozinheiro $nome, especialista em $especialidade, está preparando os pratos!")
    }

    fun prepararPedido(pedido: Pedido) {
        if (pedido.itens.isEmpty()) {
            // Lançando a exceção importada
            throw PedidoVazioException("Não é possível preparar um pedido vazio.")
        }
        println("Cozinheiro $nome preparando o pedido com os itens: ${pedido.itens.joinToString { it.nome }}")
        pedido.status = "Pronto para servir"
        println("Pedido atualizado para: ${pedido.status}")
    }
}

// CLASSE DERIVADA 2
class Garcom(nome: String, salario: Double, val areaAtendimento: String) : Funcionario(nome, salario) {
    // Sobrescrita do método (Polimorfismo)
    override fun trabalhar() {
        println("O garçom $nome está atendendo as mesas na área '$areaAtendimento'.")
    }

    fun anotarPedido(itens: List<entity.ItemMenu>): Pedido {
        println("Garçom $nome anotando um novo pedido.")
        return Pedido(itens)
    }
}