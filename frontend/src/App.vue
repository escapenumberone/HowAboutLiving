<template>
  <div id="app">
    <router-view/>
    <div id="wrapper">
      <SideBar />
      <div id="content-wrapper" class="d-flex flex-column">
        <div id="content">
          <TopBar />
          <div class="container-fluid mt-4">
            <Header />
            <Example />
          </div>
        </div>
        <Footer />
      </div>
    </div>
    <ScrollToTop />
  </div>
</template>

<script>
import SideBar from './components/SideBar';
import TopBar from './components/TopBar';
import Header from './components/Header';
import Example from './components/Example';
import Footer from './components/Footer';
import ScrollToTop from './components/ScrollToTop';

export default {
  name: 'App',
  components: {
    SideBar,
    TopBar,
    Header,
    Example,
    Footer,
    ScrollToTop
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
