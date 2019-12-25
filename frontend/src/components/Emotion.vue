<template>
    <div>
        <div v-if="this.$store.state.emotion === 'smile'">
            <h1 style="font-family: 궁서">여긴 살기 좋다우!!</h1>
            <img src="../../static/img/smile.png">
        </div>
        <div v-else-if="this.$store.state.emotion === 'impassivity'">
            <h1 style="font-family: 궁서">so so</h1>
            <img src="../../static/img/impassivity.png">
        </div>
        <div v-else-if="this.$store.state.emotion === 'angry'">
            <h1 style="font-family: 궁서">이사 생각해보는게 어때 ?</h1>
            <img src="../../static/img/angry.png">
        </div>
        <div v-else-if="this.$store.state.emotion === 'vomit'">
            <h1 style="font-family: 궁서">당장 떠나! </h1>
            <img src="../../static/img/vomit.png">
        </div>
        
        
        
        
    </div>
    
</template>

<script>
export default {
    name: 'Emotion',
    data() {
        return {
        }
    }
}
</script>

<style scoped>

</style>