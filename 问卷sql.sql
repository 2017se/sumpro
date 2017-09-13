/*
Navicat MySQL Data Transfer

Source Server         : connection
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : survey

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-09-13 10:57:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `answers`
-- ----------------------------
DROP TABLE IF EXISTS `answers`;
CREATE TABLE `answers` (
  `u_id` int(11) NOT NULL,
  `o_id` int(11) NOT NULL,
  `answer` varchar(1024) NOT NULL,
  PRIMARY KEY (`u_id`,`o_id`),
  KEY `o_id` (`o_id`),
  CONSTRAINT `answers_ibfk_1` FOREIGN KEY (`o_id`) REFERENCES `one_question` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `answers_ibfk_2` FOREIGN KEY (`u_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of answers
-- ----------------------------
INSERT INTO `answers` VALUES ('7', '85', 'B');
INSERT INTO `answers` VALUES ('7', '86', 'A');
INSERT INTO `answers` VALUES ('7', '87', 'AC');
INSERT INTO `answers` VALUES ('7', '88', '1');
INSERT INTO `answers` VALUES ('7', '89', 'A');
INSERT INTO `answers` VALUES ('7', '90', 'A');
INSERT INTO `answers` VALUES ('7', '91', '');
INSERT INTO `answers` VALUES ('7', '92', '');

-- ----------------------------
-- Table structure for `answer_questionnaire`
-- ----------------------------
DROP TABLE IF EXISTS `answer_questionnaire`;
CREATE TABLE `answer_questionnaire` (
  `u_id` int(11) NOT NULL,
  `q_id` int(11) NOT NULL,
  `submit_time` datetime DEFAULT NULL,
  `if_complete` int(1) DEFAULT '0',
  PRIMARY KEY (`u_id`,`q_id`),
  KEY `q_id` (`q_id`),
  CONSTRAINT `answer_questionnaire_ibfk_1` FOREIGN KEY (`q_id`) REFERENCES `questionnaire` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `answer_questionnaire_ibfk_2` FOREIGN KEY (`u_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of answer_questionnaire
-- ----------------------------
INSERT INTO `answer_questionnaire` VALUES ('7', '55', '2017-09-12 08:08:46', '1');
INSERT INTO `answer_questionnaire` VALUES ('7', '56', '2017-07-21 06:35:15', '0');

-- ----------------------------
-- Table structure for `one_question`
-- ----------------------------
DROP TABLE IF EXISTS `one_question`;
CREATE TABLE `one_question` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `q_id` int(11) NOT NULL,
  `title_num` int(3) NOT NULL,
  `stem` varchar(1024) NOT NULL,
  `type` int(1) DEFAULT '0',
  `nessecity` int(1) DEFAULT '1',
  `max_options` int(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK83D959BF8FB4D747` (`q_id`),
  CONSTRAINT `one_question_ibfk_1` FOREIGN KEY (`q_id`) REFERENCES `questionnaire` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=209 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of one_question
-- ----------------------------
INSERT INTO `one_question` VALUES ('85', '55', '1', '火灾初起阶段是扑救火灾的（）的阶段。', '0', '1', null);
INSERT INTO `one_question` VALUES ('86', '55', '2', '据统计，火灾中死亡的人有80%以上属于（）。', '0', '1', null);
INSERT INTO `one_question` VALUES ('87', '55', '3', '发生火灾后，如何逃生？', '1', '1', '2');
INSERT INTO `one_question` VALUES ('88', '55', '4', '着火时，当楼梯已被烧断，通道已被堵死，如何逃生？', '2', '1', null);
INSERT INTO `one_question` VALUES ('89', '56', '1', '您的性别？', '0', '1', null);
INSERT INTO `one_question` VALUES ('90', '56', '2', '网络游戏是一种良好的放松方式，你同意这种观点吗？', '0', '1', null);
INSERT INTO `one_question` VALUES ('91', '56', '3', '你觉得网游吸引你的是什么？', '1', '1', null);
INSERT INTO `one_question` VALUES ('92', '56', '4', '你觉得你不能戒掉网游的原因是什么？', '2', '1', null);
INSERT INTO `one_question` VALUES ('111', '66', '1', '性别', '0', '1', null);
INSERT INTO `one_question` VALUES ('112', '66', '2', '年龄', '0', '1', null);
INSERT INTO `one_question` VALUES ('113', '66', '3', '职业', '0', '1', null);
INSERT INTO `one_question` VALUES ('114', '66', '4', '受教育程度', '0', '1', null);
INSERT INTO `one_question` VALUES ('115', '66', '5', '姓名', '2', '0', null);
INSERT INTO `one_question` VALUES ('116', '66', '6', '电话', '2', '0', null);
INSERT INTO `one_question` VALUES ('117', '66', '7', '邮件地址', '2', '0', null);
INSERT INTO `one_question` VALUES ('118', '66', '8', '所选专业方向', '0', '1', null);
INSERT INTO `one_question` VALUES ('119', '66', '9', '选择所学专业的理由', '1', '1', '3');
INSERT INTO `one_question` VALUES ('120', '66', '10', '决定所学专业的关键人物', '0', '1', null);
INSERT INTO `one_question` VALUES ('121', '66', '11', '选择专业前对相关专业的了解程度', '0', '1', null);
INSERT INTO `one_question` VALUES ('122', '66', '12', '对选择所学专业是否满意？', '0', '1', null);
INSERT INTO `one_question` VALUES ('123', '66', '13', '如果让你重新选择，你会选择哪个专业方向？', '0', '1', null);
INSERT INTO `one_question` VALUES ('124', '66', '14', '你认为致使所选专业不理想的主要原因是什么？', '1', '0', null);
INSERT INTO `one_question` VALUES ('125', '66', '15', '对于不满意的所选专业你采取了或你准备采取什么行动？', '0', '1', null);
INSERT INTO `one_question` VALUES ('126', '66', '16', '你所从事工作的专业与所学专业之间的一致性程度如何？', '0', '1', null);
INSERT INTO `one_question` VALUES ('127', '66', '17', '所从事工作专业与所学专业不同的最主要原因是什么？', '0', '1', null);
INSERT INTO `one_question` VALUES ('128', '66', '18', '你认为在选择专业时应该着重考虑哪些方面？', '1', '1', '4');
INSERT INTO `one_question` VALUES ('129', '66', '19', '你认为哪些措施能够帮助人们选择并学习满意的专业？', '1', '1', null);

-- ----------------------------
-- Table structure for `questionnaire`
-- ----------------------------
DROP TABLE IF EXISTS `questionnaire`;
CREATE TABLE `questionnaire` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `u_id` int(11) NOT NULL,
  `title` varchar(100) NOT NULL,
  `instruction` varchar(1024) DEFAULT NULL,
  `set_date` datetime DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `u_id` (`u_id`),
  CONSTRAINT `questionnaire_ibfk_1` FOREIGN KEY (`u_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=88 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of questionnaire
-- ----------------------------
INSERT INTO `questionnaire` VALUES ('55', '5', '企业安全知识在线考试', '本次考试总分100分，考试时间30分钟！', '2017-07-21 06:09:05', '2017-10-23 06:09:33');
INSERT INTO `questionnaire` VALUES ('56', '7', '大学生网络游戏问卷调查', '您好，这是一份关于大学生玩网络游戏的调查问卷，希望能占用您两分钟时间帮忙填写一下，非常感谢！', '2017-07-21 06:28:06', '2017-10-27 06:28:12');
INSERT INTO `questionnaire` VALUES ('66', '7', '专业方向选择现状问卷调查', '为了解我国专业方向选择现状，特进行此项调查，望大家积极配合。谢谢！', '2017-09-01 00:00:00', '2017-09-30 00:00:00');

-- ----------------------------
-- Table structure for `q_options`
-- ----------------------------
DROP TABLE IF EXISTS `q_options`;
CREATE TABLE `q_options` (
  `q_id` int(11) NOT NULL,
  `title` varchar(1) NOT NULL,
  `property` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`q_id`,`title`),
  KEY `FK5688D890D2CDBBED` (`q_id`),
  CONSTRAINT `q_options_ibfk_1` FOREIGN KEY (`q_id`) REFERENCES `one_question` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of q_options
-- ----------------------------
INSERT INTO `q_options` VALUES ('85', 'A', '最不利');
INSERT INTO `q_options` VALUES ('85', 'B', '最有利');
INSERT INTO `q_options` VALUES ('85', 'C', '较有利');
INSERT INTO `q_options` VALUES ('86', 'A', '被火直接烧死');
INSERT INTO `q_options` VALUES ('86', 'B', '烟气窒息致死');
INSERT INTO `q_options` VALUES ('86', 'C', '跳楼或惊吓致死');
INSERT INTO `q_options` VALUES ('87', 'A', '坐电梯逃生');
INSERT INTO `q_options` VALUES ('87', 'B', '湿毛巾捂住口鼻');
INSERT INTO `q_options` VALUES ('87', 'C', '低姿势撤离');
INSERT INTO `q_options` VALUES ('87', 'D', '用床单或者安全绳逃生');
INSERT INTO `q_options` VALUES ('89', 'A', '男');
INSERT INTO `q_options` VALUES ('89', 'B', '女');
INSERT INTO `q_options` VALUES ('90', 'A', '完全同意');
INSERT INTO `q_options` VALUES ('90', 'B', '部分同意');
INSERT INTO `q_options` VALUES ('90', 'C', '不同意');
INSERT INTO `q_options` VALUES ('91', 'A', '画面精美');
INSERT INTO `q_options` VALUES ('91', 'B', '身边有同学或朋友在玩');
INSERT INTO `q_options` VALUES ('91', 'C', '赚钱');
INSERT INTO `q_options` VALUES ('91', 'D', 'PK');
INSERT INTO `q_options` VALUES ('111', 'a', '男');
INSERT INTO `q_options` VALUES ('111', 'b', '女');
INSERT INTO `q_options` VALUES ('112', 'a', '17岁以下');
INSERT INTO `q_options` VALUES ('112', 'b', '17-26');
INSERT INTO `q_options` VALUES ('112', 'c', '27-36');
INSERT INTO `q_options` VALUES ('112', 'd', '37-46');
INSERT INTO `q_options` VALUES ('112', 'e', '47-56');
INSERT INTO `q_options` VALUES ('112', 'f', '57-66');
INSERT INTO `q_options` VALUES ('112', 'g', '67岁及以上');
INSERT INTO `q_options` VALUES ('113', 'a', '哲学');
INSERT INTO `q_options` VALUES ('113', 'b', '经济学');
INSERT INTO `q_options` VALUES ('113', 'c', '法学');
INSERT INTO `q_options` VALUES ('113', 'd', '教育学');
INSERT INTO `q_options` VALUES ('113', 'e', '文学');
INSERT INTO `q_options` VALUES ('113', 'f', '历史学');
INSERT INTO `q_options` VALUES ('113', 'g', '理学');
INSERT INTO `q_options` VALUES ('113', 'h', '工学');
INSERT INTO `q_options` VALUES ('113', 'i', '农学');
INSERT INTO `q_options` VALUES ('113', 'j', '医学');
INSERT INTO `q_options` VALUES ('113', 'k', '军事学');
INSERT INTO `q_options` VALUES ('113', 'l', '管理学');
INSERT INTO `q_options` VALUES ('113', 'm', '艺术学');
INSERT INTO `q_options` VALUES ('114', 'a', '小学及以下');
INSERT INTO `q_options` VALUES ('114', 'b', '初中');
INSERT INTO `q_options` VALUES ('114', 'c', '高中、中专、技校');
INSERT INTO `q_options` VALUES ('114', 'd', '本科');
INSERT INTO `q_options` VALUES ('114', 'e', '硕士');
INSERT INTO `q_options` VALUES ('114', 'f', '博士及以上');
INSERT INTO `q_options` VALUES ('118', 'a', '哲学');
INSERT INTO `q_options` VALUES ('118', 'b', '经济学');
INSERT INTO `q_options` VALUES ('118', 'c', '法学');
INSERT INTO `q_options` VALUES ('118', 'd', '教育学');
INSERT INTO `q_options` VALUES ('118', 'e', '文学');
INSERT INTO `q_options` VALUES ('118', 'f', '历史学');
INSERT INTO `q_options` VALUES ('118', 'g', '理学');
INSERT INTO `q_options` VALUES ('118', 'h', '工学');
INSERT INTO `q_options` VALUES ('118', 'i', '农学');
INSERT INTO `q_options` VALUES ('118', 'j', '医学');
INSERT INTO `q_options` VALUES ('118', 'k', '军事学');
INSERT INTO `q_options` VALUES ('118', 'l', '管理学');
INSERT INTO `q_options` VALUES ('118', 'm', '艺术');
INSERT INTO `q_options` VALUES ('118', 'n', '其他');
INSERT INTO `q_options` VALUES ('119', 'a', '喜欢');
INSERT INTO `q_options` VALUES ('119', 'b', '适合');
INSERT INTO `q_options` VALUES ('119', 'c', '就业容易');
INSERT INTO `q_options` VALUES ('119', 'd', '收入高');
INSERT INTO `q_options` VALUES ('119', 'e', '工作环境好');
INSERT INTO `q_options` VALUES ('119', 'f', '社会地位高');
INSERT INTO `q_options` VALUES ('119', 'g', '应家长要求');
INSERT INTO `q_options` VALUES ('119', 'h', '应老师要求');
INSERT INTO `q_options` VALUES ('119', 'i', '其他');
INSERT INTO `q_options` VALUES ('120', 'a', '完全由本人决定');
INSERT INTO `q_options` VALUES ('120', 'b', '完全由家长决定');
INSERT INTO `q_options` VALUES ('120', 'c', '完全由老师决定');
INSERT INTO `q_options` VALUES ('120', 'd', '本人与家长协商决定');
INSERT INTO `q_options` VALUES ('120', 'e', '本人与老师协商决定');
INSERT INTO `q_options` VALUES ('120', 'f', '本人与家长、老师及其他人商量决定');
INSERT INTO `q_options` VALUES ('120', 'g', '其他');
INSERT INTO `q_options` VALUES ('121', 'a', '非常了解');
INSERT INTO `q_options` VALUES ('121', 'b', '比较了解');
INSERT INTO `q_options` VALUES ('121', 'c', '有些了解');
INSERT INTO `q_options` VALUES ('121', 'd', '不太了解');
INSERT INTO `q_options` VALUES ('121', 'e', '完全不了解');
INSERT INTO `q_options` VALUES ('122', 'a', '不满意');
INSERT INTO `q_options` VALUES ('122', 'b', '有些不满意');
INSERT INTO `q_options` VALUES ('122', 'c', '一般');
INSERT INTO `q_options` VALUES ('122', 'd', '比较满意');
INSERT INTO `q_options` VALUES ('122', 'e', '很满意');
INSERT INTO `q_options` VALUES ('123', 'a', '哲学');
INSERT INTO `q_options` VALUES ('123', 'b', '经济学');
INSERT INTO `q_options` VALUES ('123', 'c', '法学');
INSERT INTO `q_options` VALUES ('123', 'd', '教育学');
INSERT INTO `q_options` VALUES ('123', 'e', '文学');
INSERT INTO `q_options` VALUES ('123', 'f', '历史学');
INSERT INTO `q_options` VALUES ('123', 'g', '理学');
INSERT INTO `q_options` VALUES ('123', 'h', '工学');
INSERT INTO `q_options` VALUES ('123', 'i', '农学');
INSERT INTO `q_options` VALUES ('123', 'j', '医学');
INSERT INTO `q_options` VALUES ('123', 'k', '军事学');
INSERT INTO `q_options` VALUES ('123', 'l', '管理学');
INSERT INTO `q_options` VALUES ('123', 'm', '艺术');
INSERT INTO `q_options` VALUES ('123', 'n', '其他');
INSERT INTO `q_options` VALUES ('124', 'a', '对所学专业不够了解');
INSERT INTO `q_options` VALUES ('124', 'b', '对自身专长不够了解');
INSERT INTO `q_options` VALUES ('124', 'c', '家长强加于自己');
INSERT INTO `q_options` VALUES ('124', 'd', '老师强加于自己');
INSERT INTO `q_options` VALUES ('124', 'e', '相关院校宣讲人误导');
INSERT INTO `q_options` VALUES ('124', 'f', '其他');
INSERT INTO `q_options` VALUES ('125', 'a', '学完本专业并在毕业后从事该专业的工作');
INSERT INTO `q_options` VALUES ('125', 'b', '学习期间转专业');
INSERT INTO `q_options` VALUES ('125', 'c', '学习期间除所学专业外再学一个自己喜欢或认为更合适的专业并在毕业后从事相关工作');
INSERT INTO `q_options` VALUES ('125', 'd', '毕业后转学更高学历的其他专业');
INSERT INTO `q_options` VALUES ('125', 'e', '毕业后从事所学专业之外的工作');
INSERT INTO `q_options` VALUES ('125', 'f', '毕业后先从事本专业工作，以后再找机会调整');
INSERT INTO `q_options` VALUES ('125', 'g', '其他');
INSERT INTO `q_options` VALUES ('126', 'a', '完全相同');
INSERT INTO `q_options` VALUES ('126', 'b', '基本相同');
INSERT INTO `q_options` VALUES ('126', 'c', '有些不同');
INSERT INTO `q_options` VALUES ('126', 'd', '很大不同');
INSERT INTO `q_options` VALUES ('126', 'e', '完全不同');
INSERT INTO `q_options` VALUES ('126', 'f', '未知');
INSERT INTO `q_options` VALUES ('127', 'a', '不喜欢原专业 ');
INSERT INTO `q_options` VALUES ('127', 'b', '原专业不能找到合适的工作');
INSERT INTO `q_options` VALUES ('127', 'c', '不适合原专业的工作');
INSERT INTO `q_options` VALUES ('127', 'd', '原专业工作收入过低');
INSERT INTO `q_options` VALUES ('127', 'e', '原专业工作不利于个人发展');
INSERT INTO `q_options` VALUES ('127', 'f', '原专业工作环境不好');
INSERT INTO `q_options` VALUES ('127', 'g', '其他');
INSERT INTO `q_options` VALUES ('128', 'a', '本人兴趣');
INSERT INTO `q_options` VALUES ('128', 'b', '本人专长');
INSERT INTO `q_options` VALUES ('128', 'c', '父母意愿');
INSERT INTO `q_options` VALUES ('128', 'd', '就业率');
INSERT INTO `q_options` VALUES ('128', 'e', '收入');
INSERT INTO `q_options` VALUES ('128', 'f', '工作环境');
INSERT INTO `q_options` VALUES ('128', 'g', '社会地位');
INSERT INTO `q_options` VALUES ('128', 'h', '其他');
INSERT INTO `q_options` VALUES ('129', 'a', '了解自己真正的兴趣');
INSERT INTO `q_options` VALUES ('129', 'b', '了解自己的专长');
INSERT INTO `q_options` VALUES ('129', 'c', '事先对所学专业给与更多的了解');
INSERT INTO `q_options` VALUES ('129', 'd', '与家长、老师及朋友咨询商量');
INSERT INTO `q_options` VALUES ('129', 'e', '入校半年至一年再选择具体专业');
INSERT INTO `q_options` VALUES ('129', 'f', '简化转专业手续');
INSERT INTO `q_options` VALUES ('129', 'g', '其他');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `ip` varchar(20) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(40) DEFAULT NULL,
  `password` varchar(40) DEFAULT NULL,
  `name` varchar(40) DEFAULT NULL,
  `mail` varchar(100) DEFAULT NULL,
  `qq` varchar(12) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `role` int(1) DEFAULT '0',
  `authority` int(1) DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `phone` (`phone`),
  UNIQUE KEY `mail` (`mail`),
  UNIQUE KEY `ip` (`ip`) USING HASH
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (null, '5', 'tzx', '123', 'sfda', 'adsfs', '123432', '12343233', '0', '1');
INSERT INTO `user` VALUES (null, '6', '于海波', '123', '于海波', '12342@qq.com', '12324', '23', '0', '1');
INSERT INTO `user` VALUES (null, '7', 'chrome', '123', 'chrome', 'chrome@google.com', '123432422', '15821931250', '1', '1');
INSERT INTO `user` VALUES (null, '8', 'test', '123', 'test', '123@qq.com', '1234567', '12345678', '0', '1');
INSERT INTO `user` VALUES (null, '19', 'dasf', '1', 'd', 'chenfeimail@foxmail.com', '2134', '124331', '0', '0');
