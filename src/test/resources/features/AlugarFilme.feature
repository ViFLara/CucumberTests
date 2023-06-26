#language: pt

  @unitários
Funcionalidade: Alugar filme
  Como um usuário
  Eu quero cadastrar aluguéis de filmes
  Para controlar preços e datas de entrega

#Cenario: Deve alugar filme com sucesso
#  Dado um filme com estoque de 2 unidades
#  E que o preço do aluguel seja R$ 3
#  Quando alugar
#  Então o preço do aluguel será R$ 3
#  Então a data de entrega será em 1 dia
#  Então o estoque do filme será 1 unidade

Cenario: Deve alugar filme com sucesso
  Dado um filme
    | estoque | 2 |
    | preco   | 3 |
    | tipo    | comum |

  E que o preço do aluguel seja R$ 3
  Quando alugar
  Então o preço do aluguel será R$ 3
  Então a data de entrega será em 1 dia
  Então o estoque do filme será 1 unidade

Cenario: Não deve alugar filme sem estoque
  Dado um filme com estoque de 0 unidades
  Quando alugar
  Então não será possível por falta de estoque
  E o estoque do filme será 0 unidade

  #Scenario Outline
Esquema do Cenario:
  Dado um filme com estoque de 2 unidades
  E que o preço do aluguel seja R$ <preco>
  E que o tipo do aluguel seja <tipo>
  Quando alugar
  Então o preço do aluguel seja R$ <valor>
  E a data de entrega será em <qtdDias> dias
  E a pontuação será de <pontuacao> pontos

  Exemplos:
    | preco | tipo      | valor | qtdDias | pontuacao |
    | 4     | extendido | 8     | 3       | 2         |
    | 4     | comum     | 4     | 1       | 1         |
    | 5     | semanal   | 15    | 7       | 3         |

#Cenario: Deve dar condições especiais para categoria extendida
#  Dado um filme com estoque de 2 unidades
#  E que o preço do aluguel seja R$ 4
#  E que o tipo do aluguel seja extendido
#  Quando alugar
#  Então o preço do aluguel seja R$ 8
#  E a data de entrega será em 3 dias
#  E a pontuação será de 2 pontos

#Cenario: Deve alugar para categoria comum
#  Dado um filme com estoque de 2 unidades
#  E que o preço do aluguel seja R$ 4
#  E que o tipo do aluguel seja comum
#  Quando alugar
#  Então o preço do aluguel seja R$ 8
#  E a data de entrega será em 1 dias
#  E a pontuação será de 1 pontos






