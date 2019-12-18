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
            <Emotion/>
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
import Emotion from './components/Emotion';
import axios from 'axios';

export default {
  name: 'App',
  components: {
    SideBar,
    TopBar,
    Header,
    Example,
    Footer,
    ScrollToTop,
    Emotion,
  },
  data() {
    return {
      allowPosition : false,
      locInfo : {
        latitude : 0,
        longitude : 0
      }
    }
  },
  
  mounted() {
    this.initAllowLoc();
  },

  methods : {
    initAllowLoc : function() {
      window.navigator.geolocation.getCurrentPosition(this.current_position);
    },

    current_position : function(position) {
      var msg;
      this.locInfo.latitude = position.coords.latitude;
      this.locInfo.longitude = position.coords.longitude;
      this.fetchRerverseGeocoding();
    },

    fetchRerverseGeocoding : function() {
      axios({
        methos : 'GET',
        url : 'http://localhost:8080/geocoding',
        params : {
          latitude : this.locInfo.latitude,
          longitude : this.locInfo.longitude
        }
      }).then((response) => {
        console.log(response.data);
      }).catch((error) => {
        console.log("ERROR 발생");
      })
    }
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
