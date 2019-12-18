<template>
  <div id="app">
    <router-view/>
    <Header/>
    <Emotion/>
    <Footer/>
  </div>
</template>

<script>
import Header from './components/Header';
import Smile from './components/Smile';
import Statistics from './components/Statistics';
import Footer from './components/Footer';
import Emotion from './components/Emotion';
import axios from 'axios';

export default {
  name: 'App',
  components: {
    Header,
    Emotion,
    Statistics,
    Footer
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

#fixedFooter{
    position:fixed;
    left: 0px;
    bottom: 0px;
    width: 100%;
    text-align: center;
}

</style>
