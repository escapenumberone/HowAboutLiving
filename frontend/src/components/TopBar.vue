<template>
              <!-- topbar -->
        <nav class="navbar-light bg-white topbar mb-4 static-top shadow text-center">
            <h1 class="display-4">{{currentLocation}}</h1>
        </nav>

</template>

<script>

export default {
    name: 'TopBar',
    props: {
        currentLocation: String
    },
    components: {
        
    },
    data(){
        return {
            
        }
    },
    methods: {

    }
}
</script>