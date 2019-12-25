<template>
  <div id="app">
    <router-view/>
    <div id="wrapper">
      <SideBar />
      <div id="content-wrapper" class="d-flex flex-column">
        <div id="content">
          <TopBar :currentLocation="whereAmI" />
          <div class="container-fluid mt-4">
            <!-- <Header /> -->
            <div v-if="this.$store.state.mainPage === 'Emotion'">
              <Emotion/>
            </div>
            <div v-else>
              <Statistics/>
            </div>
            <!-- <Example /> -->
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
import Statistics from './components/Statistics';
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
    Statistics
  },
  data() {
    return {
      allowPosition : false,
      locInfo : {
        latitude : 0,
        longitude : 0
      },
      whereAmI: "",
    }
  },
  
  mounted() {
    this.initAllowLoc();
    this.fetchEnvironmentSevendays();
  },

  methods : {
    initAllowLoc : async function() {
      window.navigator.geolocation.getCurrentPosition(this.current_position);
    },

    current_position : function(position) {
      var msg;
      this.locInfo.latitude = position.coords.latitude;
      this.locInfo.longitude = position.coords.longitude;
      this.fetchRerverseGeocoding();
    },

    fetchRerverseGeocoding : function() {
      var temp = this;
      axios({
        methos : 'GET',
        url : 'http://localhost:8080/geocoding',
        params : {
          latitude : this.locInfo.latitude,
          longitude : this.locInfo.longitude
        }
      }).then((response) => {
        console.log(response.data);
        temp.whereAmI = response.data;
        var str = temp.whereAmI;
        var strArray = str.split(' ')
        this.$store.state.whereAmI = strArray[strArray.length - 1];
        console.log(this.$store.state.whereAmI);
     }).catch((error) => {
        console.log("ERROR 발생");
      })
    },
    fetchEnvironmentSevendays : function() {
        var temp = this;
        axios({
            methos : 'GET',
            url : 'http://localhost:8080/environment/sevendays/' + this.$store.state.whereAmI,
        }).then((response) => {
            if(response.status === 204){
                this.$store.state.whereAmI = this.$store.state.whereAmI.substring(0, this.$store.state.whereAmI.length - 1);
                console.log(this.$store.state.whereAmI);
                temp.fetchEnvironmentSevendaysAgain();
            } else {
                console.log(response.data.sevendaysList);
                this.$store.state.environmentSevendays = response.data.sevendaysList;
                temp.whereAmI = response.data;
            }
        }).catch((error) => {
            console.log("ERROR 발생");
        })
    },
    fetchEnvironmentSevendaysAgain : function() {
        var temp = this;
        axios({
            methos : 'GET',
            url : 'http://localhost:8080/environment/sevendays/' + this.$store.state.whereAmI,
        }).then((response) => {
            console.log(response.data.sevendaysList);
            this.$store.state.environmentSevendays = response.data.sevendaysList;
            temp.whereAmI = response.data;
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
