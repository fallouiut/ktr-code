# Based on node
FROM node:16-alpine as build

# copy project dir to root of here
COPY front ./front

RUN ls
# Workdir is front
WORKDIR /front

# import dependencies
RUN npm i -g @angular/cli
RUN npm i

# run app
ENTRYPOINT ["ng", "serve"]
