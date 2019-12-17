<template>
    <div>
  <b-navbar toggleable="lg" type="dark" variant="info">
    <b-navbar-brand href="#">
        <b-img src="../assets/escapenumberoneLogo.png" thumbnail fluid width="50px" height="50px" alt="살기어때 로고"></b-img>
    </b-navbar-brand>

    <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

    <b-collapse id="nav-collapse" is-nav>
      <b-navbar-nav>
        <b-nav-text>텍스트</b-nav-text>
        <b-nav-item class="mx-auto" width="100px" href="#">Link</b-nav-item>
      </b-navbar-nav>
    </b-collapse>
  </b-navbar>
    </div>
</template>

<script>
export default {
    name: 'Header',
    data() {
        return {

        }
    }
}
</script>