<template>
  <div id="app">
    <router-view/>
    <Header/>
    <img src="./assets/logo.png">
    <HelloWorld/>
  </div>
</template>

<script>
import Header from './components/Header';
import HelloWorld from './components/HelloWorld';

export default {
  name: 'App',
  components: {
    Header,
    HelloWorld
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  /* margin-top: 60px; */
}
</style>
