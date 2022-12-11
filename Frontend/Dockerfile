FROM node:14.11.0 as build

WORKDIR /app
ENV PATH /app/node_modules/.bin:$PATH

COPY package.json /app/package.json
RUN npm install
RUN npm install -g @angular/cli@10.1.2

COPY . /app

RUN ng build --prod=true --aot=true --output-path=dist

FROM nginx:1.19.2-alpine

COPY --from=build /app/dist /usr/share/nginx/html
COPY ./nginx /etc/nginx

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]
