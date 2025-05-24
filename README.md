# Conversor de Moedas
Aplicativo de conversão de moedas feito em Java, com interface simples utilizando Swing. O programa permite converter valores entre diversas moedas da América Latina e o Brasil, utilizando dados reais obtidos através da **API Exchange Rate**.

<p align="center">
  <img src="https://github.com/user-attachments/assets/e60dc1b0-36d8-49b1-8b06-6209f5db43dc" alt="Interface do Aplicativo" />
</p>



## 🚀 Tecnologias utilizadas

- **Java** 
- **Consumo de API REST** com java.net.http.HttpClient
  
## 🌎 Funcionalidades

- Conversão entre as seguintes moedas:
  - Dólar (USD)
  - Peso argentino (ARS)
  - Peso colombiano (COP)
  - Real Brasileiro (BRL)
  - Peso Chileno (CLP)

## 🛠️ Como executar

1. Clone o repositório.
```bash 
   git clone https://github.com/ColeSkywalker/ConversorDeMoedasComInterface.git
```
2. Compile o projeto:
```bash 
   javac -d bin src/br/com/conversordemoeda/**/*.java
```
3. Execute o Main:
```bash 
   java -cp bin br.com.conversordemoeda.app.ConversorGUI
```
## 🔗 API utilizada

[Exchange Rate API](https://www.exchangerate-api.com/)
