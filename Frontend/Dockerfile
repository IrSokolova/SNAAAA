FROM node:16-alpine3.15 as build

WORKDIR /app
ENV PATH /app/node_modules/.bin:$PATH

COPY package.json /app/package.json
RUN npm install -g npm@9.2.0
RUN npm install -g @angular/cli@10.1.2
RUN npm install --save-dev @angular-devkit/build-angular --force

COPY . /app

RUN ng build --prod=false --aot=true --output-path=dist

FROM nginx:1.23.2-alpine

COPY --from=build /app/dist /usr/share/nginx/html
COPY ./nginx /etc/nginx

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]
