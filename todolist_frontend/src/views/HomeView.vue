<template>
    <div>
        <TodoListComponent />
        <router-link to="/create">
            <button>NEW</button>
        </router-link>
    </div>
</template>

<script>
import TodoListComponent from '../components/TodoListComponent.vue';

export default {
    components: {
        TodoListComponent,
    },
};
</script>