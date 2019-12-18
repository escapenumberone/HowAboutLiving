<template>
    <div>
        <h1>여긴 살기 좋다우!!</h1>
        <img v-if="emotion === 'smile'" src="../../static/img/smile.png">
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
            emotion : "smile"
        }
    }
}
</script>

<style scoped>

</style>