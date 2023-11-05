# Angular

This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 16.2.6.

## Development server

Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The application will automatically reload if you change any of the source files.

## Code scaffolding

Run `ng generate component component-name` to generate a new component. You can also use `ng generate directive|pipe|service|class|guard|interface|enum|module`.

## Build

Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory.

## Running unit tests

Run `ng test` to execute the unit tests via [Karma](https://karma-runner.github.io).

## Running end-to-end tests

Run `ng e2e` to execute the end-to-end tests via a platform of your choice. To use this command, you need to first add a package that implements end-to-end testing capabilities.

## Further help

To get more help on the Angular CLI use `ng help` or go check out the [Angular CLI Overview and Command Reference](https://angular.io/cli) page.

## Running angular app with quarkus rest service

Angular runs on port 4200 and calls to the backend will use port 4200.
To use the backend over port 8080 the following steps have to be done.

### Configure proxy

Update proxy.conf.json
```
{
    "/api/*": {
        "target": "http://127.0.0.1:8080",
        "secure": false,
        "logLevel": "debug"
    }
}
```

### Configure app start

Change package.json
```
"start": "ng serve"
```
to 
```
"start": "ng serve --proxy-config proxy.conf.json"
```

Run the angular app with
```shell script
npm start
```

# use primeng

## install primeng

```shell script
npm install primebg
npm install primeflex
```

## import styles

update styles.css
```shell script
@import "primeng/resources/themes/lara-light-blue/theme.css";
@import "primeng/resources/primeng.css";
```
