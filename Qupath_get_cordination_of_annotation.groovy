import org.locationtech.jts.io.WKTWriter
import java.io.BufferedWriter
import java.io.FileWriter
import java.io.IOException

// 获取所有注释对象
def annotations = getAnnotationObjects()

// 初始化 Well-known text (WKT) Writer
def writer = new WKTWriter()

// 每微米约有 4.709 个像素
def pixelsPerMicron = 4.709

try {
    // 创建 BufferedWriter，并指定文件路径
    def bufferedWriter = new BufferedWriter(new FileWriter("D:/research/analysis/qupath/scanpy/output_wkt.txt"))

    // 循环遍历每个注释对象并输出其 WKT 表示
    annotations.each { annotation ->
        // 获取注释的几何对象并输出 WKT
        def geometry = annotation.getROI().getGeometry()
        def wkt = writer.write(geometry)

        // 将坐标从像素转换为um
        def convertedWkt = convertPixelsToMicrons(wkt, pixelsPerMicron)

        // 输出到控制台或写入文件
        println convertedWkt
        bufferedWriter.write(convertedWkt)
        bufferedWriter.newLine() // 换行，每个 WKT 一行
    }

    // 关闭 BufferedWriter
    bufferedWriter.close()
} catch (IOException e) {
    e.printStackTrace()
}

// 将像素坐标转换为um坐标
def convertPixelsToMicrons(wkt, pixelsPerMicron) {
    def convertedWkt = wkt.replaceAll(/(-?\d+(\.\d+)?)/) { match ->
        def pixelCoordinate = match[0] as double
        def micronCoordinate = pixelCoordinate / pixelsPerMicron
        micronCoordinate = micronCoordinate.round(2) // 保留两位小数
        "${micronCoordinate}"
    }
    return convertedWkt
}