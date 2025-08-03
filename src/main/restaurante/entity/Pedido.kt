package entity

data class Pedido(val itens : List<ItemMenu>, var status : String = "Aguardando preparo")