<template>
    <el-card class="item">
        <div class="time">{{time | formatDate("DATETIME")}}</div>
        <el-input type="textarea" v-model="newNotes" :id="'notes' + id"></el-input>
<!--        <i class="el-icon-s-opportunity" :style="{color: notes === newNotes ? '#67C23A' : '#E6A23C'}"></i>-->
        <el-button-group class="btn-group">
            <el-button icon="el-icon-success" type="success" size="mini" v-if="notes !== newNotes"
                       v-on:click="save">保存
            </el-button>
            <el-button icon="el-icon-document-copy" type="primary" size="mini"  class="copy" :data-clipboard-target="'#notes' + id">复制</el-button>
            <el-button icon="el-icon-delete-solid" type="danger" size="mini" v-on:click="deleteNotes">删除</el-button>
        </el-button-group>
    </el-card>
</template>

<script>
    import Clipboard from 'clipboard';
    import {Message} from 'element-ui';

    const clipboard = new Clipboard('.copy');
    clipboard.on('success', function (e) {

        Message({
            message: "已复制到剪切板",
            type: "success"
        })
    });
    export default {
        name: 'NotesItem',
        props: {
            notes: String,
            id: Number,
            time: Number
        },
        data() {
            return {
                newNotes:""
            }
        },
        created() {
            this.newNotes = this.notes;
        },
        watch: {
          notes(val) {
              if (val === undefined) {
                  this.newNotes = ''
              }
          }
        },
        methods: {
            save() {
                const url = 'notes';
                if (this.id !== undefined && this.id !== null && this.id !== -1) {
                    this.axios.put(url, {id: this.id, notes: this.newNotes}).then(() => {
                        // this.$message({
                        //     type: "success",
                        //     message: "保存成功"
                        // });
                        this.$emit("refresh")
                    })
                } else {
                    this.axios.post(url, {notes: this.newNotes}).then(() => {
                        // this.$message({
                        //     type: "success",
                        //     message: "保存成功"
                        // });
                        this.$emit("refresh")
                    })
                }
            },
            deleteNotes() {
                if (this.id !== undefined && this.id !== null && this.id !== -1) {
                    const url = 'notes/' + this.id;
                    this.axios.delete(url).then(() => {
                       this.$emit("refresh")
                    });
                } else {
                    this.$emit("refresh")
                }
            },
            copy() {

            }
        }
    }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style>
    .el-card__body {
        padding: 10px;
    }
    .item {
        margin: 10px;
    }

    .time {
        font-size: 12px;
        color: dimgrey;
        width: 100%;
        text-align: left;
    }
    .btn-group {
        margin-top: 5px;
    }
</style>
