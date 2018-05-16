package com.example.hb.service;

import com.example.common.util.FileUtil;
import com.example.entity.LotteryHistory;
import com.example.hb.repository.LotteryHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class ReadExcelFileService {

    @Autowired
    LotteryHistoryRepository lotteryHistoryRepository;

    public void readExcelFile(String fileName) {
        String path = Thread.currentThread()
                .getContextClassLoader().getResource("").getPath() + "/com/example/hb/service/" + fileName + ".xls";

        File xlsfile = new File(path);
        String[][] data = null;
        try {
            data = FileUtil.getData(xlsfile, 2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        LotteryHistory lotteryHistory = null;
        for (int i = 0; i < data.length; i++) {
            lotteryHistory = new LotteryHistory();
            lotteryHistory.setId(Long.valueOf(data[i][2]));

            String item[] = data[i][3].split(" ");
            lotteryHistory.setBlue1(Integer.valueOf(item[0]));
            lotteryHistory.setBlue2(Integer.valueOf(item[1]));
            lotteryHistory.setBlue3(Integer.valueOf(item[2]));
            lotteryHistory.setBlue4(Integer.valueOf(item[3]));
            lotteryHistory.setBlue5(Integer.valueOf(item[4]));
            lotteryHistory.setBlue6(Integer.valueOf(item[5]));
            lotteryHistory.setRed(Integer.valueOf(item[6]));

            String item1[] = data[i][4].split(",");
            String sales = item1[0] + item1[1] + item1[2];
            lotteryHistory.setSales(Double.valueOf(sales));

            String FirstPrizeAmount = "0";
            if (!"0".equals(data[i][6])) {
                String item2[] = data[i][6].split(",");
                FirstPrizeAmount = item2[0] + item2[1] + item2[2];
            }

            String SecondPrizeAmount = "0";
            if (!"0".equals(data[i][8])) {
                String item3[] = data[i][8].split(",");
                SecondPrizeAmount = item3[0] + item3[1];
            }

            String ThirdPrizeAmount = "0";
            if (!"0".equals(data[i][10])) {
                String item4[] = data[i][10].split(",");
                ThirdPrizeAmount = item4[0] + item4[1];
            }


            lotteryHistory.setFirstPrizeCount(Long.valueOf(data[i][5]));
            lotteryHistory.setFirstPrizeAmount(Double.valueOf(FirstPrizeAmount));
            lotteryHistory.setSecondPrizeCount(Long.valueOf(data[i][7]));
            lotteryHistory.setSecondPrizeAmount(Double.valueOf(SecondPrizeAmount));
            lotteryHistory.setThirdPrizeCount(Long.valueOf(data[i][9]));
            lotteryHistory.setThirdPrizeAmount(Double.valueOf(ThirdPrizeAmount));
            lotteryHistoryRepository.save(lotteryHistory);
        }
    }
}
