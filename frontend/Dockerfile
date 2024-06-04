# Use uma imagem Node.js como base
FROM node:14-alpine

# Defina o diretório de trabalho
WORKDIR /app

# Copie os arquivos package.json e package-lock.json para o diretório de trabalho
COPY package.json package-lock.json ./

# Instale as dependências
RUN npm install

# Copie todo o código fonte para o diretório de trabalho
COPY . .

# Compile o aplicativo React para produção
RUN npm run build

# Instale o servidor HTTP para servir a aplicação
RUN npm install -g serve

# Exponha a porta que o aplicativo vai rodar
EXPOSE 3000

# Comando para rodar a aplicação
CMD ["serve", "-s", "build"]
