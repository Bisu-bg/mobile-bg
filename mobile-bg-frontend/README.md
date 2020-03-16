# ASML technical documentation

## Table of contents:

- [Introduction](#introduction)
- [Setup instructions](#setup-instructions)
- [Project structure](#project-structure)
- [Available scripts](#available-scripts)

## Introduction

> The goal of this document is to provide detailed information on some of the architectural aspects and decisions behind the ASML frontend.

## Setup instructions

> Install Node (this will also install npm which is needed for the next step)
> Open a terminal from the project terminal and execute `npm install`.

## Project structure

> This project was bootstrapped with [Create React App](https://github.com/facebookincubator/create-react-app). The project structure is as follows:

|           |                   |                   |
| --------  | ----------------- | ----------------- |
| frontend/ |                   |                   |
|           | README.md         |                   |
|           | node_modules/     |                   |
|           | package.json      |                   |
|           | package_lock.json |                   |
|           | .gitignore        |                   |
|           | public/           |                   |
|           |                   | index.html        |
|           |                   | favicon.ico       |
|           | src/              |                   |
|           |                   | api/              |
|           |                   | common/           |
|           |                   | components/       |
|           |                   | containers/       |
|           |                   | reducers/         |
|           |                   | sagas/            |
|           |                   | configureStore.js |
|           |                   | index.css         |
|           |                   | index.js          |


## Available Scripts

> In the project directory, you can run:

### `npm run start`

> Start node server at http://localhost:3000/ 

### `npm run build`

> Builds the app for production to the `build` folder.<br>
> It correctly bundles React in production mode and optimizes the build for the best performance.
> The build is minified and the filenames include the hashes.<br>
> Your app is ready to be deployed!
