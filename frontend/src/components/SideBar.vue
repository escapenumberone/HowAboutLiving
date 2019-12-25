<template>
    <!-- Sidebar -->
      <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">
  
        <!-- Sidebar - Brand -->
        <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.html">
          <div class="sidebar-brand-icon">
            <img src="../../static/img/escapenumberoneLogo.png" width="50px" height="50px"/>
          </div>
          <div class="sidebar-brand-text mx-3">살기어때</div>
        </a>
  
        <!-- Divider -->
        <hr class="sidebar-divider my-0">
  
        <!-- Divider -->
        <hr class="sidebar-divider">
  
        <!-- Nav Item - Pages Collapse Menu -->
        <li @click="clickMain" class="nav-item">
          <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo">
            <i class="fas fa-fw fa-cog"></i>
            <span >Main</span>
          </a>
        </li>
  
        <!-- Nav Item - Utilities Collapse Menu -->
        <li @click="clickStatistics" class="nav-item">
          <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities" aria-expanded="true" aria-controls="collapseUtilities">
            <i class="fas fa-fw fa-wre nch"></i>
            <span >Statistics</span>
          </a>
        </li>
        
      </ul>
      <!-- End of Sidebar -->
</template>

<script>

export default {
    name: 'Sidebar',
    components: {

    },
    data(){
        return {

        };
    },
    methods: {
      clickMain: function(){
        this.$store.state.mainPage = 'Emotion'
      },
      clickStatistics: function(){
        this.$store.state.mainPage = 'Statistics'
      }
    }
}
</script>