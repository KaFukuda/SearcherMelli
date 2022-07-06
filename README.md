# SEARCHMELI  <img alt="android" src="https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white" />  <img alt="Kotlin" src="https://img.shields.io/badge/kotlin-%230095D5.svg?&style=for-the-badge&logo=kotlin&logoColor=orange"/>

Aplicação criada com objetivo de consumir APIs do Mercado Livre, e assim trazer resultados de pesquisa de produtos definidos por categorias e seus detalhes.

---

## TELAS PRINCIPAIS
<div align="left"> 
  <img height="780" width="400" src="https://github.com/KaFukuda/images/blob/main/Tela_Inicial_Lista.png"/>
  <img height="780" width="400" src="https://github.com/KaFukuda/images/blob/main/Tela_Detalhe_Produto.png"/>
</div>

---

### FUNCIONALIDADES

Na tela Principal: 

- Filtra por uma categoria quando o usuário digita uma palavra
- Retorna uma lista com os 20 primeiros itens da categoria da busca
- Opção de favoritar o item pelo ícone de coração
- Ao clicar no produto, altera de tela contendo detalhes dele
- Em cada produto traz a informações de:
     - Imagem
     - Título
     - Preço total do produto
     - Preço parcelado em 12X
     - Quantidade de itens disponíveis para venda

Na tela de Produtos:

- Traz a opção de favoritar o produto pelo ícone de coração
- Traz a informação do item clicado da tela anterior ( HOME ) 
- Mostra informações de:
    - Imagem
    - Título
    - Preço total do produto
    - Descrição completa do produto

---

### TECNOLOGIAS

- Kotlin 
- Android Studio
- Git
- Figma 
- Postman

---

### RECURSOS 

- RecyclerView
- Activity
- Shared Preferences
- Retrofit
- Coroutines

---

### ESTRUTURA BASE

<div align="center">
  <img height="700" width="400" src="https://github.com/KaFukuda/images/blob/main/estrutura.png"/>
</div>

---

### PARA ACESSAR O PROJETO LOCALMENTE

#### !! Instalação necessária:
 
Você precisará do [Android Studio](https://developer.android.com/studio)

#### CLONE

Certifique-se que tenha o [Git](https://git-scm.com/downloads) instalado

Para clonar esse projeto, faça isso em um terminal:

``
git clone https://github.com/KaFukuda/SearcherMelli.git
``
---- 

#### Se tem acesso das APIs Mercado Livre:

###### Será necessário seguir procedimentos de pré-token para gerar um Bearer Token e usá-lo nesse projeto nas constantes abaixo

Então,

Use o arquivo ``envExample.kt`` como base de constantes de desevolvimento.

Altere o nome para ``env.kt``

Altere o valor das constantes :

`` 
const val API_BASE_URL = "https://"
const val TOKEN = "APP_....."
``

---

#### Se não tem acesso as Apis Mercado livre:

Altere os serviços e chamadas do diretório ``service`` conforme sua necessidade

---

Caso tenha melhorias, abra uma issue e vamos analisar juntos! OBRIGADA ;)