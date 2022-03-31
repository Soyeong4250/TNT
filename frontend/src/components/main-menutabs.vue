<template>
  <MDBTabs v-model="activeTabId2">
    <!-- Tabs navs -->
    <MDBTabNav fill tabsClasses="mb-6">
      <MDBTabItem tabId="ex2-1" href="ex2-1">정치</MDBTabItem>
      <MDBTabItem tabId="ex2-2" href="ex2-2">경제</MDBTabItem>
      <MDBTabItem tabId="ex2-3" href="ex2-3">사회</MDBTabItem>
      <MDBTabItem tabId="ex2-4" href="ex2-4">문화</MDBTabItem>
      <MDBTabItem tabId="ex2-5" href="ex2-5">Another link</MDBTabItem>
      <MDBTabItem tabId="ex2-6" href="">Another link</MDBTabItem>
    </MDBTabNav>
    <!-- Tabs navs -->
    <!-- Tabs content -->
    <MDBTabContent>
      <MDBTabPane tabId="ex2-1">Tab 1 content</MDBTabPane>
      <MDBTabPane tabId="ex2-2">Tab 2 content</MDBTabPane>
      <MDBTabPane tabId="ex2-3">Tab 3 content</MDBTabPane>
      <MDBTabPane tabId="ex2-4">Tab 1 content</MDBTabPane>
      <MDBTabPane tabId="ex2-5">Tab 2 content</MDBTabPane>
      <MDBTabPane tabId="ex2-6">Tab 3 content</MDBTabPane>
    </MDBTabContent>
    <!-- Tabs content -->
  </MDBTabs>
</template>

<script>
  import {
    MDBTabs,
    MDBTabNav,
    MDBTabContent,
    MDBTabItem,
    MDBTabPane,
  } from 'mdb-vue-ui-kit';
  import { ref } from 'vue';
  export default {
    components: {
      MDBTabs,
      MDBTabNav,
      MDBTabContent,
      MDBTabItem,
      MDBTabPane,
    },
    setup() {
      const activeTabId2 = ref('ex2-1');
      return {
        activeTabId2,
      };
    },
  };
</script>

<style>

</style>