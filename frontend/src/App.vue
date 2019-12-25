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
    this.computeDisaster();
    // this.computeEmotion();
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
      var temp = this;
      axios({
        methos : 'GET',
        url : 'http://123.2.134.115:8080/geocoding',
        params : {
          latitude : this.locInfo.latitude,
          longitude : this.locInfo.longitude
        }
      }).then((response) => {
        console.log(response.data);
        temp.whereAmI = response.data;
        this.$store.state.currenLocation = temp.whereAmI;
        var str = temp.whereAmI;
        var strArray = str.split(' ')
        this.$store.state.whereAmI = strArray[strArray.length - 1];
        console.log(this.$store.state.whereAmI);
        temp.fetchEnvironmentSevendays();
        temp.fetchDisasterRealtime();
     }).catch((error) => {
        console.log("ERROR 발생");
      })
    },
    fetchEnvironmentRealtime : function() {
        var temp = this;
        axios({
            methos : 'GET',
            url : 'http://123.2.134.115:8080/environment/realtime/' + this.$store.state.whereAmI,
        }).then((response) => {
            if(response.status === 204){
                this.$store.state.whereAmI = this.$store.state.whereAmI.substring(0, this.$store.state.whereAmI.length - 1);
                console.log(this.$store.state.whereAmI);
                temp.fetchEnvironmentRealtimeAgain();
            } else {
                console.log(response.data.realtimeList);
                this.$store.state.environmentRealtime = response.data.realtimeList[0];
                temp.computeEmotion();
            }
        }).catch((error) => {
            console.log("일주일 데이터 못가져옴 발생");
        })
    },
    fetchEnvironmentRealtimeAgain : function() {
        var temp = this;
        axios({
            methos : 'GET',
            url : 'http://123.2.134.115:8080/environment/realtime/' + this.$store.state.whereAmI,
        }).then((response) => {
            console.log(response.data.realtimeList);
            this.$store.state.environmentRealtime = response.data.realtimeList[0];
            temp.computeEmotion();
        }).catch((error) => {
            console.log("ERROR 발생");
        })
    },

    fetchDisasterRealtime : function() {
        var temp = this;
        axios({
            methos : 'GET',
            url : 'http://123.2.134.115:8080/disaster/list/' + '충청북도 영동군',
        }).then((response) => {
            if(response.status === 204){
                temp.fetchDisasterRealtimeAgain();
            } else {
                this.$store.state.disasterRealtime = response.data.disasterList;
                temp.computeDisaster();
            }
        }).catch((error) => {
            console.log("일주일 데이터 못가져옴 발생");
        })
    },
    fetchDisasterRealtimeAgain : function() {
        var temp = this;
        axios({
            methos : 'GET',
            url : 'http://123.2.134.115:8080/disaster/list/' + '충청북도 영동군',
        }).then((response) => {
            this.$store.state.disasterRealtime = response.data.disasterList;
            temp.computeDisaster();
        }).catch((error) => {
            console.log("ERROR 발생");
        })
    },

    fetchEnvironmentSevendays : function() {
        var temp = this;
        axios({
            methos : 'GET',
            url : 'http://123.2.134.115:8080/environment/sevendays/' + this.$store.state.whereAmI,
        }).then((response) => {
            if(response.status === 204){
                this.$store.state.whereAmI = this.$store.state.whereAmI.substring(0, this.$store.state.whereAmI.length - 1);
                console.log(this.$store.state.whereAmI);
                temp.fetchEnvironmentSevendaysAgain();
            } else {
                console.log(response.data.sevendaysList);
                this.$store.state.environmentSevendays = response.data.sevendaysList;
                temp.fetchEnvironmentRealtime();
            }
        }).catch((error) => {
            console.log("일주일 데이터 못가져옴 발생");
        })
    },
    fetchEnvironmentSevendaysAgain : function() {
        var temp = this;
        axios({
            methos : 'GET',
            url : 'http://123.2.134.115:8080/environment/sevendays/' + this.$store.state.whereAmI,
        }).then((response) => {
            console.log(response.data.sevendaysList);
            this.$store.state.environmentSevendays = response.data.sevendaysList;
            temp.fetchEnvironmentRealtime();
        }).catch((error) => {
            console.log("ERROR 발생");
        })
    },
    fetchEnvironmentSevendaysAgain : function() {
        var temp = this;
        axios({
            methos : 'GET',
            url : 'http://123.2.134.115:8080/environment/sevendays/' + this.$store.state.whereAmI,
        }).then((response) => {
            console.log(response.data.sevendaysList);
            this.$store.state.environmentSevendays = response.data.sevendaysList;
            temp.fetchEnvironmentRealtime();
        }).catch((error) => {
            console.log("ERROR 발생");
        })
    },
    computeDisaster : function() {
          var temp = this.$store.state.disasterRealtime;
          temp.forEach(element => {
            if(element.dsstrRiskType === '침수위험'){
                this.$store.state.floodingRisk++;
            } else if(element.dsstrRiskType === '붕괴시설'){
                this.$store.state.decayFacility++;
            } else if(element.dsstrRiskType === '고립위험'){
                this.$store.state.isolationRisk++;
            } else {
                this.$store.state.Riskofloss++;
            }
          });
    },
  computeEmotion : function() {
      console.log("asdasd");
      if(this.$store.state.environmentRealtime.all_grade <= 1){
        this.$store.state.emotion = 'smile';
      } else if(this.$store.state.environmentRealtime.all_grade <= 2){
        this.$store.state.emotion = 'impassivity';
      } else if(this.$store.state.environmentRealtime.all_grade <= 3){
        this.$store.state.emotion = 'angry';
      } else {
        this.$store.state.emotion = 'vomit';
      }
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
