__author__ = 'abarbi'
import numpy as np
import cv2
from PIL import Image
from matplotlib import pyplot as plt



image= cv2.imread('images6.jpg')
image1 = cv2.cvtColor(image, cv2.COLOR_BGR2GRAY)
cv2.imwrite('images61.jpg',image1)

#mask = cv2.imread('mask2.png',0)

#dst = cv2.inpaint(img,mask,3,cv2.INPAINT_TELEA)

img = cv2.imread('images61.jpg')
img1 = cv2.fastNlMeansDenoising(img,None,3,7,21)
cv2.imwrite('images62.jpg',img1)
plt.subplot(121),plt.imshow(img)
plt.subplot(122),plt.imshow(img1)
plt.show()