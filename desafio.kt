enum class Nivel {
    BASICO,
    INTERMEDIARIO,
    AVANCADO
}

data class Usuario(val nome: String, val nivel: Nivel)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {
    val inscritos = mutableListOf<Usuario>()
    fun matricular(vararg usuarios: Usuario) {
        for (usuario in usuarios) {
            
            // Verifica se o usuário já está matriculado
            if (!inscritos.contains(usuario)) {
                inscritos.add(usuario)
                println(
                        "Usuário ${usuario.nome} matriculado na formação: $nome com nível ${usuario.nivel}."
                )
                println("Contéudo: ${conteudos[1]}")
                
            } else {
                println("Usuário ${usuario.nome} já está matriculado nesta formação.")
            }
        }
    }
}

fun main() {
    val usuario1 = Usuario("João", Nivel.BASICO)
    val usuario2 = Usuario("Maria", Nivel.INTERMEDIARIO)
    val usuario3 = Usuario("Carlos", Nivel.AVANCADO)

    val conteudo1 = ConteudoEducacional("Introdução ao Kotlin", 90)
    val conteudo2 = ConteudoEducacional("Programação Orientada a Objetos", 120)

    val formacao = Formacao("Desenvolvimento de Software", listOf(conteudo1, conteudo2))

    formacao.matricular(usuario1, usuario2)
    formacao.matricular(usuario3)
    formacao.matricular(
            usuario1,
            usuario2,
            usuario3
    )

    println("Alunos matriculador ${formacao.nome}: ${formacao.inscritos}")
}
