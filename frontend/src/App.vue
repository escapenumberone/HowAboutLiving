<template>
  <div id="app">
    <router-view/>
    <Header/>
    <img src="./assets/logo.png">
    <Smile/>
    <Statistics/>
    <Footer/>
  </div>
</template>

<script>
import Header from './components/Header';
import Smile from './components/Smile';
import Statistics from './components/Statistics';
import Footer from './components/Footer';

export default {
  name: 'App',
  components: {
    Header,
    Smile,
    Statistics,
    Footer
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

#fixedFooter{
    position:fixed;
    left: 0px;
    bottom: 0px;
    width: 100%;
    text-align: center;
}

</style>
