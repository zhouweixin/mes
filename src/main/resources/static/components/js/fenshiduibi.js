/** 控制室 */
var fenshiduibi = {
    labels: [],
    data1: [],
    data2:[],
    realDataIntervals: [],
    ino: 43,
    timeGap: 24,
    start1: null,
    start2: null,
    end1: null,
    end2: null,
    init: function () {
        Chart.defaults.global.animation = {
            duration : 0,
            easing : 'easeInOutCirc',
        }
        /** 给日期添加格式化的原型方法*/
        // fenshiduibi.funcs.updateDate()
        /** 初始化日期控件日期控件  todo当选择日期控件的日期后,会相应的把end1和end2中的值填满*/
        layui.use('laydate', function () {
            var laydate = layui.laydate
            laydate.render({
                elem: '#start1',//指定元素
                format: 'yyyy-MM-dd HH:mm:ss',
                done: function (value, date, endDate) {
                    fenshiduibi.timeGap = Number($('#timeGapInp').val())
                    var date = fenshiduibi.funcs.addHourAndRender(date, fenshiduibi.timeGap)
                    var end1Val = date.Format("yyyy-MM-dd hh:mm:ss")
                    $('#end1').val(end1Val)
                }
            })
            laydate.render({
                elem: '#start2',  //指定元素
                format: 'yyyy-MM-dd HH:mm:ss',
                done: function (value, date, endDate) {
                    fenshiduibi.timeGap = Number($('#timeGapInp').val())
                    var date = fenshiduibi.funcs.addHourAndRender(date, fenshiduibi.timeGap)
                    var end2Val = date.Format("yyyy-MM-dd hh:mm:ss")
                    $('#end2').val(end2Val)
                }
            })
        })
        /** 数据加载 */
        fenshiduibi.funcs.bindSelectChangeEvent($('#model-li-hide-15-select'))
        /** 点击一二级菜单会清空intervals的事件绑定 */
        fenshiduibi.funcs.bindClearInterval()
        /** 清除intervals */
        home.funcs.clearIntervals(fenshiduibi.realDataIntervals)
        /** 初始化的图表 */
        fenshiduibi.funcs.bindSubmitEvent($('#submitBtn'))
        /** 清除interval */
        home.funcs.clearIntervals(fenshiduibi.realDataIntervals)
    },
    funcs: {
        addHourAndRender: function (date, gap) {
            return new Date(date.year, date.month - 1, date.date, date.hours + gap, date.minutes, date.seconds)
        },
        bindSubmitEvent: function (submitBtn) {
            home.funcs.clearIntervals(fenshiduibi.realDataIntervals)
            submitBtn.off('click')
            submitBtn.on('click', function () {
                fenshiduibi.timeGap = $('#timeGapInp').val()
                fenshiduibi.start1 = $('#start1').val()
                fenshiduibi.start2 = $('#start2').val()
                fenshiduibi.end1 = $('#end1').val()
                fenshiduibi.end2 = $('#end2').val()
                //console.log(fenshiduibi.timeGap)
                //console.log(fenshiduibi.start1)
                //console.log(fenshiduibi.start2)
                //console.log(fenshiduibi.end1)
                //console.log(fenshiduibi.end2)
                if (!fenshiduibi.timeGap || !fenshiduibi.start1 || !fenshiduibi.start2 || !fenshiduibi.end1 || !fenshiduibi.end2) {
                    alert('您的查询条件还没填写完整!')
                    return
                }
                /** 首先马上查询一次*/
                fenshiduibi.funcs.loadDataAndRender()

                /** 接下来每30秒查询一次 */
                /** 开始间隔30秒获取数据 */
                fenshiduibi.funcs.bindLoadDataEvent()
            })
        },
        bindClearInterval: function () {
            $('#menu3-li-15').on('click', function () {
                home.funcs.clearIntervals(fenshiduibi.realDataIntervals)
                fenshiduibi.funcs.bindLoadDataEvent()
            })
            $('.menus2').off('click')
            $('.menus2').on('click', function () {
                home.funcs.clearIntervals(fenshiduibi.realDataIntervals)
            })
            $('.menus1').off('click')
            $('.menus1').on('click', function () {
                home.funcs.clearIntervals(fenshiduibi.realDataIntervals)
            })
        },
        /** 每隔30秒查询一次 */
        bindLoadDataEvent: function () {
            fenshiduibi.realDataIntervals.push(setInterval(function () {
                fenshiduibi.funcs.loadDataAndRender()
            }, 30000))
        },
        bindSelectChangeEvent: function (select) {
            select.on('change', function () {
                console.log($(this).val())
            })
        },
        createChart: function (labels, data1, data2) {
            /** 创建曲线图 */
            var data = {
                //折线图需要为每个数据点设置一标签。这是显示在X轴上。
                /** 横坐标 */
                labels : labels,
                //数据集（y轴数据范围随数据集合中的data中的最大或最小数据而动态改变的）
                datasets: [
                    {
                        label: "时间段1能耗值曲线",
                        fill: false,
                        backgroundColor: "rgba(54, 162, 235,1)",
                        borderColor: "rgba(54, 162, 235,1)",
                        pointRadius: 3,
                        /** 纵坐标 */
                        data : data1
                    },
                    {
                        label: "时间段2能耗值曲线",
                        fill: false,
                        backgroundColor: "rgba(255, 99, 132,1)",
                        borderColor: "rgba(255, 99, 132,1)",
                        pointRadius: 3,
                        /** 纵坐标 */
                        data : data2
                    }
                ]
            }
            $('.canvas-container').empty();
            $('.canvas-container').append("<canvas id='myChart' style='width: 100%;height: 50%;min-width: 800px;min-height: 350px;'></canvas>")
            var ctx = document.getElementById("myChart").getContext("2d");
            var myChart = new Chart(ctx, {
                type: 'line',
                data: data
            })
        },
        fillLabelsAndData1: function (data) {
            fenshiduibi.data1 = []
            fenshiduibi.labels = []
            data.forEach(function (e) {
                fenshiduibi.data1.push(e.ivalue)
                fenshiduibi.labels.push(e.ihour)
            })

        },
        fillData2 : function(data) {
            fenshiduibi.data2 = []
            data.forEach(function(e){
                fenshiduibi.data2.push(e.ivalue)
            })
        },
        loadDataAndRender: function () {
            $.get(home.urls.energyMonitor.loadFenshiduibiData(), {
                ino: fenshiduibi.ino,
                startDateTime: new Date(fenshiduibi.start1).getTime(),
                endDateTime: new Date(fenshiduibi.end1).getTime()
            }, function (result) {
                /** 获取到数据后 */
                /** 首先填满数据 */
                fenshiduibi.funcs.fillLabelsAndData1(result.data)
            })
            $.get(home.urls.energyMonitor.loadFenshiduibiData(), {
                ino: fenshiduibi.ino,
                startDateTime: new Date(fenshiduibi.start2).getTime(),
                endDateTime: new Date(fenshiduibi.end2).getTime()
            }, function (result) {
                fenshiduibi.funcs.fillData2(result.data)
            })
            var time = setTimeout(function() {
                fenshiduibi.funcs.createChart(fenshiduibi.labels, fenshiduibi.data1,fenshiduibi.data2)
                clearTimeout(time)
            },1000) //这里必须设置一个时间阈值，要不然可能数据还没有完全加载好
        }
    }
}
