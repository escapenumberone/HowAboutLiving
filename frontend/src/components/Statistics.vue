<template>
    <div>
        <h1>통계 화면</h1>
        <div>
            <div class="left">
                <span class="locDisaster">재해 : {{}}</span>
                <br>
                <span class="statisticsDisaster">22건</span>
                <br>
            </div>
            <div class="right">
                환경쪽 그래프
            </div>
        </div>
        <div>
            <LineChart/>
        </div>
    </div>
</template>



<script>
import LineChart from './LineChart';
import axios from 'axios';

export default {
    name: 'Emotion',
    components: {
      LineChart
    },
    data() {
        return {
            emotion : "vomit"
        }
    },

    mounted() {
        //this.fetchEnvironmentSevendays();
    },

    methods : {
        

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
</style>