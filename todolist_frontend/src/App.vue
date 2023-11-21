<template>
    <div class="todoList" id="app">
        <router-view />
    </div>
</template>

<style>
.todoList {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    color: white;
    font-family: BlinkMacSystemFont,-apple-system,Segoe UI,Roboto,Helvetica,Arial,sans-serif;
}

body, html {
    margin: 0;
    padding: 0;
    height: 100%;
    width: 100%;
    background-color: #006ce4;
}

</style>

<script>
export default {
    name: 'App',
}
</script>