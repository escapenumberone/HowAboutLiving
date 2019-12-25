<template>
    <div>
        <h1>통계 화면</h1>
        <div>
            <div class="left">
                <span class="locDisaster">재해(경기도 기준)</span>
                <span class="statisticsDisaster">66/300</span>
                <div class="charts">
                    <span>chart--default</span>
                    <div class="charts__chart chart--p88 chart--default" data-percent></div><!-- /.charts__chart -->
                    <span>chart--blue</span>
                    <div class="charts__chart chart--p80 chart--blue" data-percent></div><!-- /.charts__chart -->
                    <span>chart--green</span>
                    <div class="charts__chart chart--p60 chart--green" data-percent></div><!-- /.charts__chart -->
                    <span>chart--red</span>
                    <div class="charts__chart chart--p40 chart--red" data-percent></div><!-- /.charts__chart -->
                    <span>chart--yellow</span>
                    <div class="charts__chart chart--p20 chart--yellow" data-percent></div><!-- /.charts__chart -->
                    <span>chart--grey</span>
                    <div class="charts__chart chart--p5 chart--grey" data-percent></div><!-- /.charts__chart -->
                </div>
                <!-- <LineChart/> -->
            </div>
            <div class="right">
                환경쪽 그래프
                <!-- <LineChart/> -->
            </div>
        </div>
        <div>
            <LineChart/>
        </div>
    </div>
</template>

<script>
import LineChart from './LineChart';

export default {
    name: 'Emotion',
    components: {
      LineChart
    },
    data() {
        return {
            emotion : "vomit"
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
</style>