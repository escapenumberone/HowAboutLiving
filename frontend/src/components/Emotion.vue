<template>
    <div>
        <h1>hiru</h1>
        <h1> {{emotion}}</h1>
        <img v-if="emotion === 'Smile'" src="../../static/img/smile.png">
        <img v-else-if="emotion === 'impassivity'" src="../../static/img/impassivity.png">
        <img v-else-if="emotion === 'angry'" src="../../static/img/angry.png">
        <img v-else-if="emotion === 'vomit'" src="../../static/img/vomit.png">
    </div>
    
</template>

<script>
export default {
    name: 'Emotion',
    data() {
        return {
            emotion : "vomit"
        }
    }
}
</script>

<style scoped>

</style>