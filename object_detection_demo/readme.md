### Detect objects with TensorFlow Object Detection API.
The [TensorFlow Object Detection API](https://github.com/tensorflow/models/tree/master/research/object_detection)
is an open source framework built on top of TensorFlow that makes it easy to construct,
train and deploy **object detection** models.

There are 2 main components:
   01. [model training script](01_training_script) - 
       Google Colab `*.ipynb` scripts to use an object detection API.
       There are two scripts: [`demo_1.ipynb`](https://colab.research.google.com/drive/1OkqFXb1GSxi7oNkiGfGttSmhaob4ivFy)
       uses existing pre-trained model from the
       [model zoo](https://github.com/tensorflow/models/blob/master/research/object_detection/g3doc/detection_model_zoo.md)
       and [`demo_2.ipynb`]()
       describes the process of creating your own dataset and training a new model.
   02. [mobile app](02_mobile_app) -
       a mobile application that uses model in Android.

To run model on your mobile phone:
   * Take existing pre-trained model
     ([`demo_1.ipynb`](https://colab.research.google.com/drive/1OkqFXb1GSxi7oNkiGfGttSmhaob4ivFy))
     or train your own model on a new dataset
     ([`demo_2.ipynb`]()).
   * Save file with your model to the Google Drive.
   * Get downloadable direct link using direct link generator for
     [Google Drive](https://www.wonderplugin.com/online-tools/google-drive-direct-link-generator),
     [Dropbox or Onedrive](https://syncwithtech.blogspot.com/p/direct-download-link-generator.html).
   * Replace link in the mobile app `???` file on your link.
   * Run mobile app in Android Studio and enjoy!

Links:
   * Shareable link to file
     [`object_detection_demo_1.ipynb`](https://colab.research.google.com/drive/1OkqFXb1GSxi7oNkiGfGttSmhaob4ivFy).
     On GitHub `*.ipynb` documents usually do not open.
   * Shareable link to file
     [`object_detection_demo_2.ipynb`]().
   * Original article: [How to configure Tensorflow object detection API with google colab](https://chamaradodandeniya.wordpress.com/2019/04/16/how-to-configure-google-colab-for-object-detection-using-tensorflow/).
   * Original article: [How to train an object detection model easy for free](https://medium.com/swlh/how-to-train-an-object-detection-model-easy-for-free-f388ff3663e).
   * [Object Detection Demo](https://github.com/tensorflow/models/blob/master/research/object_detection/object_detection_tutorial.ipynb) for the local computer (not Colab).
   * Pretrained models in the [Tensorflow detection model zoo](https://github.com/tensorflow/models/blob/master/research/object_detection/g3doc/detection_model_zoo.md).
