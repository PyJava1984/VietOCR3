/**
 * Copyright @ 2012 Quan Nguyen
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package net.sourceforge.vietocr;

import java.io.File;
import java.util.List;
import javax.imageio.IIOImage;
import net.sourceforge.tess4j.Tesseract;

public class OCRImages extends OCR<IIOImage> {

    Tesseract instance;
    final String TESSDATA = "tessdata";

    OCRImages(String tessPath) {
        instance = Tesseract.getInstance();
        instance.setPageSegMode(Integer.parseInt(this.getPageSegMode()));
        instance.setDatapath(new File(tessPath, TESSDATA).getPath());
    }

    @Override
    public String recognizeText(List<IIOImage> images, String lang) throws Exception {
        instance.setLanguage(lang);
        String text = instance.doOCR(images, rect);

        return text;
    }
}
