__author__ = 'abarbi'

from scipy import misc
from skimage import color
fimg = misc.imread("num0.jpg")

gimg = color.colorconv.rgb2grey(fimg)
from skimage import measure
contours = measure.find_contours(gimg, 0.8)