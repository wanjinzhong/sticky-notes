<template>
    <div id="app">
        <div class="header">
            <h3>Sticky Notes</h3>
        </div>
        <div class="content">
            <div>
                <i v-if="add" class="el-icon-circle-plus add" v-on:click="createNew"></i>
            </div>
            <div v-if="notes.length === 0" class="no-data-tips">还没有数据</div>
            <div v-else class="total-tips">总共：{{notes.length}}</div>
            <NotesItem v-if="notes.length !== 0" v-for="n in notes" :key="n.id" :id="n.id" :notes="n.notes"
                       :time="n.time"
                       @refresh="refresh"></NotesItem>
        </div>
    </div>
</template>

<script>

    import NotesItem from "./components/NotesItem";

    export default {
        name: 'app',
        components: {NotesItem},
        data() {
            return {
                notes: [],
                add: true
            }
        },
        mounted() {
            this.refresh();
        },
        methods: {
            createNew() {
                this.notes.unshift({id: -1, notes: null, time: new Date().getTime()})
                this.add = false;
            },
            refresh() {
                const url = "notes";
                this.axios.get(url).then(res => {
                    this.notes = res.data
                });
                this.add = true;
            }
        }
    }
</script>

<style>
    #app {
        font-family: 'Avenir', Helvetica, Arial, sans-serif;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
        text-align: center;
        color: #2c3e50;
    }

    .no-data-tips {
        color: dimgrey;
        font-size: 14px;
        font-style: italic;
    }

    .total-tips {
        color: dimgrey;
        font-size: 13px;
        font-style: italic;
        text-align: left;
        margin: 0 10px;
    }

    .add {
        font-size: 25px;
        color: #67C23A;
        cursor: pointer;
    }
</style>
