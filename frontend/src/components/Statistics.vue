<template>
    <div>
        <h1>통계 화면</h1>
        <div>
            <div class="left">
                <BarChart/>
            </div>
            <div class="right">
                <table class="table table-borderless" style="border-collapse: separate;">
                <thead>
                    <tr>
                    <th scope="col"></th>
                    <th scope="col">
                        좋음
                        <hr style="width: 80px; height: 6px; background-color: blue">
                    </th>
                    <th scope="col">
                        보통
                        <hr style="width: 80px; height: 6px; background-color: green">
                    </th>
                    <th scope="col">
                        나쁨
                        <hr style="width: 80px; height: 6px; background-color: yellow">
                    </th>
                    <th scope="col">
                        매우나쁨
                        <hr style="width: 80px; height: 6px; background-color: red">
                    </th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                    <th stype="" scope="row">미세먼지</th>
                    <td :class="{'circle-selected' : this.finedustFlagFirst}">0 ~ 30</td>
                    <td :class="{'circle-selected' : this.finedustFlagSecond}">31 ~ 50</td>
                    <td :class="{'circle-selected' : this.finedustFlagThird}">51 ~ 100</td>
                    <td :class="{'circle-selected' : this.finedustFlagFourth}">101 ~</td>
                    </tr>
                    <tr>
                    <th scope="row">초미세먼지</th>
                    <td :class="{'circle-selected' : this.finedustFlagFirst_ultra}">0 ~ 15</td>
                    <td :class="{'circle-selected' : this.finedustFlagSecond_ultra}">16 ~ 25</td>
                    <td :class="{'circle-selected' : this.finedustFlagThird_ultra}">26 ~ 50</td>
                    <td :class="{'circle-selected' : this.finedustFlagFourth_ultra}">51 ~</td>
                    </tr>
                    <tr>
                    <th scope="row">오존</th>
                    <td :class="{'circle-selected' : this.ozoneFlagFirst}">0 ~ 0.009</td>
                    <td :class="{'circle-selected' : this.ozoneFlagSecond}">0.01 ~ 0.09</td>
                    <td :class="{'circle-selected' : this.ozoneFlagThird}">0.1 ~ 0.15</td>
                    <td :class="{'circle-selected' : this.ozoneFlagFourth}">0.151 ~</td>
                    </tr>
                </tbody>
                </table>
            </div>
        </div>
        <div>
            <LineChart/>
        </div>
    </div>
</template>



<script>
import LineChart from './LineChart';
import BarChart from './BarChart';
import axios from 'axios';

export default {
    name: 'Emotion',
    components: {
      LineChart,
      BarChart
    },
    data() {
        return {
            emotion : "vomit",
            finedustFlagFirst: false,
            finedustFlagSecond: false,
            finedustFlagThird: false,
            finedustFlagFourth: false,
            finedustFlagFirst_ultra: false,
            finedustFlagSecond_ultra: false,
            finedustFlagThird_ultra: false,
            finedustFlagFourth_ultra: false,
            ozoneFlagFirst: false,
            ozoneFlagSecond: false,
            ozoneFlagThird: false,
            ozoneFlagFourth: false,
        }
    },

    mounted() {
        this.computeCircle();
    },

    methods : {
        computeCircle : function() {
            // 미세먼지 서클 계산
            if(this.$store.state.environmentRealtime.finedust_value <= 30){
                this.finedustFlagFirst = true;
            } else if(this.$store.state.environmentRealtime.finedust_value <= 50){
                this.finedustFlagSecond = true;
            } else if(this.$store.state.environmentRealtime.finedust_value <= 100){
                this.finedustFlagThird = true;
            } else {
                this.finedustFlagFourth = true;
            }

            // 초미세먼지 서클 계산
            if(this.$store.state.environmentRealtime.ultra_finedust_value <= 15){
                this.finedustFlagFirst_ultra = true;
            } else if(this.$store.state.environmentRealtime.ultra_finedust_value <= 25){
                this.finedustFlagSecond_ultra = true;
            } else if(this.$store.state.environmentRealtime.ultra_finedust_value <= 50){
                this.finedustFlagThird_ultra = true;
            } else {
                this.finedustFlagFourth_ultra = true;
            }

            // 오존 서클 계산
            if(this.$store.state.environmentRealtime.o3_value <= 0.009){
                this.ozoneFlagFirst = true;
            } else if(this.$store.state.environmentRealtime.o3_value <= 0.09){
                this.ozoneFlagSecond = true;
            } else if(this.$store.state.environmentRealtime.o3_value <= 0.15){
                this.ozoneFlagThird = true;
            } else {
                this.ozoneFlagFourth = true;
            }
        }

    }
}
</script>

<style scoped>
    .left{
        padding: 15px;
        width: 47%;
        /* float: left; */
        display: inline-block;
    }
    .right{
        padding: 15px;
        width: 47%;
        /* float: right; */
        display: inline-block;
    }
    .locDisaster{
        float: left;
    }
    .statisticsDisaster{
        float: right;
    }
    .circle-selected{
        border-radius: 15px; border: 2px solid #3ec5f1
    }
    .circle-selectedd{
        border-radius: 15px; border: 2px solid #3ec5f1
    }
</style>