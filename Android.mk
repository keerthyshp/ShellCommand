LOCAL_PATH:= $(call my-dir)
include $(CLEAR_VARS)

LOCAL_PACKAGE_NAME := ShellCommand

LOCAL_SRC_FILES := $(call all-java-files-under,java)

LOCAL_SDK_VERSION := current
LOCAL_PROGUARD_ENABLED := disabled
LOCAL_CERTIFICATE := platform
LOCAL_PRIVILEGED_MODULE := true
 
LOCAL_REQUIRED_MODULES := com.keerthy.shellcommand-def-perm.xml

include $(BUILD_PACKAGE)

include $(call all-makefiles-under,$(LOCAL_PATH))


#------------------------------------
# Default permissions
#------------------------------------
include $(CLEAR_VARS)
LOCAL_MODULE := com.keerthy.shellcommand-def-perm.xml
LOCAL_MODULE_TAGS := optional
LOCAL_MODULE_CLASS := ETC
LOCAL_MODULE_PATH := $(TARGET_OUT_ETC)/default-permissions
LOCAL_SRC_FILES := default-permissions/com.keerthy.shellcommand.xml
include $(BUILD_PREBUILT)
