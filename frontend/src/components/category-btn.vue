<template>
  <div class="mx-auto">
    <b-button-group style="border-style: outset">
      <b-button variant="light" @click="searchPolitics">정치</b-button>
      <b-button variant="light" @click="searchEconomy">경제</b-button>
      <b-button variant="light" @click="searchSociety">사회</b-button>
      <b-button variant="light" @click="searchLife">생활/문화</b-button>
      <b-button variant="light" @click="searchIT">IT/과학</b-button>
      <b-button variant="light" @click="searchOpinion">오피니언</b-button>
    </b-button-group>
  </div>
</template>

<script>
export default {
  data() {
    return {};
  },
  methods: {
    searchPolitics: function () {
      this.$router.push({ name: "Search", params: { query: "정치" } });
    },
    searchEconomy: function () {
      this.$router.push({ name: "Search", params: { query: "경제" } });
    },
    searchSociety: function () {
      this.$router.push({ name: "Search", params: { query: "사회" } });
    },
    searchLife: function () {
      this.$router.push({ name: "Search", params: { query: "생활" } });
    },
    searchIT: function () {
      this.$router.push({ name: "Search", params: { query: "IT" } });
    },
    searchOpinion: function () {
      this.$router.push({ name: "Search", params: { query: "오피니언" } });
    },
  },
};
</script>

<style></style>
