(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-4d55"],{A2HV:function(t,e,n){},BuNJ:function(t,e,n){},Mz3J:function(t,e,n){"use strict";Math.easeInOutQuad=function(t,e,n,i){return(t/=i/2)<1?n/2*t*t+e:-n/2*(--t*(t-2)-1)+e};var i=window.requestAnimationFrame||window.webkitRequestAnimationFrame||window.mozRequestAnimationFrame||function(t){window.setTimeout(t,1e3/60)};function a(t,e,n){var a=document.documentElement.scrollTop||document.body.parentNode.scrollTop||document.body.scrollTop,l=t-a,s=0;e=void 0===e?500:e;!function t(){s+=20,function(t){document.documentElement.scrollTop=t,document.body.parentNode.scrollTop=t,document.body.scrollTop=t}(Math.easeInOutQuad(s,a,l,e)),s<e?i(t):n&&"function"==typeof n&&n()}()}var l={name:"Pagination",props:{total:{required:!0,type:Number},page:{type:Number,default:1},limit:{type:Number,default:10},pageSizes:{type:Array,default:function(){return[10,20,30,50]}},layout:{type:String,default:"total, sizes, prev, pager, next, jumper"},background:{type:Boolean,default:!0},autoScroll:{type:Boolean,default:!0},hidden:{type:Boolean,default:!1}},computed:{currentPage:{get:function(){return this.page},set:function(t){this.$emit("update:page",t)}},pageSize:{get:function(){return this.limit},set:function(t){this.$emit("update:limit",t)}}},methods:{handleSizeChange:function(t){this.$emit("pagination",{page:this.currentPage,limit:t}),this.autoScroll&&a(0,800)},handleCurrentChange:function(t){this.$emit("pagination",{page:t,limit:this.pageSize}),this.autoScroll&&a(0,800)}}},s=(n("vY5d"),n("KHd+")),o=Object(s.a)(l,function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"pagination-container",class:{hidden:t.hidden}},[n("el-pagination",t._b({attrs:{background:t.background,"current-page":t.currentPage,"page-size":t.pageSize,layout:t.layout,"page-sizes":t.pageSizes,total:t.total},on:{"update:currentPage":function(e){t.currentPage=e},"update:pageSize":function(e){t.pageSize=e},"size-change":t.handleSizeChange,"current-change":t.handleCurrentChange}},"el-pagination",t.$attrs,!1))],1)},[],!1,null,"8681615a",null);o.options.__file="index.vue";e.a=o.exports},"Y/a6":function(t,e,n){"use strict";n.r(e);var i=n("zM89"),a=n("7Qib"),l=[{key:"is not null ",display_name:"全部"},{key:"=0 ",display_name:"等于0"},{key:" between 0 and 10 ",display_name:"0s到10s"},{key:" between 11 and 30 ",display_name:"11s到30s"},{key:" >30 ",display_name:"大于30s"}],s={name:"BillList",components:{Pagination:n("Mz3J").a},filters:{statusFilter:function(t){return{published:"success",draft:"info",deleted:"danger"}[t]}},data:function(){var t=this;return{list:null,durationOptions:l,total:0,listLoading:!0,downLoading:!1,listQuery:{calltype:"14",pageNum:1,pageSize:10,caller:"",called:"",durationConditon:"",startTime:"",endTime:""},pickerOptions0:{disabledDate:function(e){return""!==t.listQuery.endTime?e.getTime()>Date.now()||Object(a.b)(e.getTime(),"{y}{m}{d}")>t.listQuery.endTime:e.getTime()>Date.now()}},pickerOptions1:{disabledDate:function(t){return t.getTime()>Date.now()}}}},created:function(){this.getList()},methods:{getList:function(){var t=this;this.listLoading=!0,Object(i.a)(this.listQuery).then(function(e){t.list=e.data.list,t.total=e.data.total,t.listLoading=!1})},handleFilter:function(){this.listQuery.pageNum=1,this.getList()},handleSizeChange:function(t){this.listQuery.pageSize=t,this.getList()},handleCurrentChange:function(t){this.listQuery.pageNum=t,this.getList()},handleDownload:function(){window.open("http://118.178.233.127:8080/pluponform/bill/excel?caller="+this.listQuery.caller+"&called="+this.listQuery.called+"&endTime="+this.listQuery.endTime+"&durationConditon="+this.listQuery.durationConditon+"&startTime="+this.listQuery.startTime+"&calltype="+this.listQuery.calltype,"_blank")}}},o=(n("cnrl"),n("KHd+")),r=Object(o.a)(s,function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"app-container"},[n("div",{staticClass:"filter-container",staticStyle:{"margin-bottom":"5px"}},[n("span",[t._v("主叫号码:")]),t._v(" "),n("el-input",{staticClass:"filter-item",staticStyle:{width:"150px"},nativeOn:{keyup:function(e){return"button"in e||!t._k(e.keyCode,"enter",13,e.key,"Enter")?t.handleFilter(e):null}},model:{value:t.listQuery.caller,callback:function(e){t.$set(t.listQuery,"caller",e)},expression:"listQuery.caller"}}),t._v(" "),n("span",[t._v("拨打号码:")]),t._v(" "),n("el-input",{staticClass:"filter-item",staticStyle:{width:"150px"},nativeOn:{keyup:function(e){return"button"in e||!t._k(e.keyCode,"enter",13,e.key,"Enter")?t.handleFilter(e):null}},model:{value:t.listQuery.called,callback:function(e){t.$set(t.listQuery,"called",e)},expression:"listQuery.called"}}),t._v(" "),n("span",[t._v("呼叫时长:")]),t._v(" "),n("el-select",{staticClass:"filter-item",staticStyle:{width:"130px"},attrs:{clearable:""},model:{value:t.listQuery.durationConditon,callback:function(e){t.$set(t.listQuery,"durationConditon",e)},expression:"listQuery.durationConditon"}},t._l(t.durationOptions,function(t){return n("el-option",{key:t.key,attrs:{label:t.display_name,value:t.key}})})),t._v(" "),n("span",[t._v("呼叫时间:")]),t._v(" "),n("el-date-picker",{staticStyle:{width:"150px"},attrs:{"picker-options":t.pickerOptions0,type:"date","value-format":"yyyyMMdd",placeholder:"选择日期"},model:{value:t.listQuery.startTime,callback:function(e){t.$set(t.listQuery,"startTime",e)},expression:"listQuery.startTime"}}),t._v(" "),n("span",[t._v("--")]),t._v(" "),n("el-date-picker",{staticStyle:{width:"150px"},attrs:{"picker-options":t.pickerOptions1,type:"date","value-format":"yyyyMMdd",placeholder:"选择日期"},model:{value:t.listQuery.endTime,callback:function(e){t.$set(t.listQuery,"endTime",e)},expression:"listQuery.endTime"}}),t._v(" "),n("el-button",{staticClass:"filter-item",attrs:{loading:t.listLoading,type:"primary",icon:"el-icon-search"},on:{click:t.handleFilter}},[t._v(t._s("查询"))]),t._v(" "),n("el-button",{staticClass:"filter-item",attrs:{loading:t.downLoading,type:"primary",icon:"el-icon-download"},on:{click:t.handleDownload}},[t._v(t._s("导出"))])],1),t._v(" "),n("el-table",{directives:[{name:"loading",rawName:"v-loading",value:t.listLoading,expression:"listLoading"}],staticStyle:{width:"100%"},attrs:{data:t.list,border:"",fit:"","highlight-current-row":""}},[n("el-table-column",{attrs:{align:"center",label:"序号",width:"80"},scopedSlots:t._u([{key:"default",fn:function(e){return[n("span",[t._v(t._s(e.$index+1+(t.listQuery.pageNum-1)*t.listQuery.pageSize))])]}}])}),t._v(" "),n("el-table-column",{attrs:{align:"center",label:"客户名称"},scopedSlots:t._u([{key:"default",fn:function(e){return[n("span",[t._v(t._s("南京乾璟通网络科技有限公司"))])]}}])}),t._v(" "),n("el-table-column",{attrs:{width:"180px",align:"center",label:"主叫号码"},scopedSlots:t._u([{key:"default",fn:function(e){return[n("span",[t._v(t._s(e.row.caller))])]}}])}),t._v(" "),n("el-table-column",{attrs:{width:"180px",align:"center",label:"拨打号码"},scopedSlots:t._u([{key:"default",fn:function(e){return[n("span",[t._v(t._s(e.row.called))])]}}])}),t._v(" "),n("el-table-column",{attrs:{width:"180px",align:"center",label:"呼叫时间"},scopedSlots:t._u([{key:"default",fn:function(e){return[n("span",[t._v(t._s(e.row.calltime))])]}}])}),t._v(" "),n("el-table-column",{attrs:{width:"120px",align:"center",label:"呼叫时长"},scopedSlots:t._u([{key:"default",fn:function(e){return[n("span",[t._v(t._s(e.row.duration))])]}}])}),t._v(" "),n("el-table-column",{attrs:{width:"120px",align:"center",label:"呼叫结果"},scopedSlots:t._u([{key:"default",fn:function(e){return[n("span",[t._v(t._s("正常挂机"))])]}}])}),t._v(" "),n("el-table-column",{attrs:{width:"120px",align:"center",label:"计费(元)"},scopedSlots:t._u([{key:"default",fn:function(e){return[n("span",[t._v(t._s(e.row.cost))])]}}])})],1),t._v(" "),n("pagination",{directives:[{name:"show",rawName:"v-show",value:t.total>0,expression:"total>0"}],attrs:{total:t.total,page:t.listQuery.pageNum,limit:t.listQuery.pageSize},on:{"update:page":function(e){t.$set(t.listQuery,"pageNum",e)},"update:limit":function(e){t.$set(t.listQuery,"pageSize",e)},pagination:t.getList}})],1)},[],!1,null,"0bb99e55",null);r.options.__file="tz.vue";e.default=r.exports},cnrl:function(t,e,n){"use strict";var i=n("A2HV");n.n(i).a},vY5d:function(t,e,n){"use strict";var i=n("BuNJ");n.n(i).a},zM89:function(t,e,n){"use strict";n.d(e,"a",function(){return a});var i=n("t3Un");function a(t){return Object(i.a)({url:"/bill/queryList",method:"get",params:t})}}}]);