<template>
    <div>
        <h1>hiru</h1>
        <h1> {{emotion}}</h1>
        <img v-if="emotion === 'Smile'" src="../assets/smile.png">
        <img v-else-if="emotion === 'impassivity'" src="../assets/impassivity.png">
        <img v-else-if="emotion === 'angry'" src="../assets/angry.png">
        <img v-else-if="emotion === 'vomit'" src="../assets/vomit.png">
    </div>
    
</template>

<script>
export default {
    data() {
        return {
            emotion : "vomit"
        }
    }
}
</script>

<style scoped>

</style>