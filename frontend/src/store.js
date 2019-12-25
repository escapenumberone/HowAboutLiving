// store.js
import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

export const store = new Vuex.Store({
    state: {
        mainPage : "Emotion",
        currentLocation : "",
        disasterCnt : 0,
        whereAmI : "",
        disasterRealtime : [
          // {
          //   dsstrRiskType : "침수위험"
          // },
          // {
          //   dsstrRiskType : "침수위험"
          // },
          // {
          //   dsstrRiskType : "유실위험"
          // },
          // {
          //   dsstrRiskType : "붕괴시설"
          // },
          // {
          //   dsstrRiskType : "침수위험"
          // },
          // {
          //   dsstrRiskType : "붕괴시설"
          // },
        ],
        environmentRealtime : {
        },
        environmentSevendays : [],
        floodingRisk : 0,
        decayFacility : 0,
        isolationRisk : 0,
        Riskofloss : 0,
        emotion : "smile"
    },
    
  // ...
});