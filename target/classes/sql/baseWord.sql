/*
 Navicat Premium Data Transfer

 Source Server         : 47.106.200.126
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : 47.106.200.126:3306
 Source Schema         : sakura

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 01/11/2019 15:10:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for baseWord
-- ----------------------------
DROP TABLE IF EXISTS `baseWord`;
CREATE TABLE `baseWord`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roma` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '罗马音',
  `ping` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '平假名',
  `pian` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '片假名',
  `row_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '行名',
  `col_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '段名',
  `type` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '清音:0 浊音1 半浊音2 拗音3 拨音9',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `roma_index`(`roma`) USING BTREE COMMENT '罗马音索引',
  INDEX `ping_index`(`ping`) USING BTREE COMMENT '平假名索引',
  INDEX `pian_index`(`pian`) USING BTREE COMMENT '片假名索引'
) ENGINE = InnoDB AUTO_INCREMENT = 105 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of baseWord
-- ----------------------------
INSERT INTO `baseWord` VALUES (1, 'a', 'あ', 'ア', 'あ', 'あ', '0');
INSERT INTO `baseWord` VALUES (2, 'i', 'い', 'イ', 'あ', 'い', '0');
INSERT INTO `baseWord` VALUES (3, 'u', 'う', 'ウ', 'あ', 'う', '0');
INSERT INTO `baseWord` VALUES (4, 'e', 'え', 'エ', 'あ', 'え', '0');
INSERT INTO `baseWord` VALUES (5, 'o', 'お', 'オ', 'あ', 'お', '0');
INSERT INTO `baseWord` VALUES (6, 'ka', 'か', 'カ', 'か', 'あ', '0');
INSERT INTO `baseWord` VALUES (7, 'ki', 'き', 'キ', 'か', 'い', '0');
INSERT INTO `baseWord` VALUES (8, 'ku', 'く', 'ク', 'か', 'う', '0');
INSERT INTO `baseWord` VALUES (9, 'ke', 'け', 'ケ', 'か', 'え', '0');
INSERT INTO `baseWord` VALUES (10, 'ko', 'こ', 'コ', 'か', 'お', '0');
INSERT INTO `baseWord` VALUES (11, 'sa', 'さ', 'サ', 'さ', 'あ', '0');
INSERT INTO `baseWord` VALUES (12, 'si', 'し', 'シ', 'さ', 'い', '0');
INSERT INTO `baseWord` VALUES (13, 'su', '	す', 'ス', 'さ', 'う', '0');
INSERT INTO `baseWord` VALUES (14, 'se', 'せ', 'セ', 'さ', 'え', '0');
INSERT INTO `baseWord` VALUES (15, 'so', 'そ', 'ソ', 'さ', 'お', '0');
INSERT INTO `baseWord` VALUES (16, 'ta', 'た', 'タ', 'た', 'あ', '0');
INSERT INTO `baseWord` VALUES (17, 'ti', 'ち', 'チ', 'た', 'い', '0');
INSERT INTO `baseWord` VALUES (18, 'tsu', 'つ', 'ツ', 'た', 'う', '0');
INSERT INTO `baseWord` VALUES (19, 'te', 'て', 'テ', 'た', 'え', '0');
INSERT INTO `baseWord` VALUES (20, 'to', 'と', 'ト', 'た', 'お', '0');
INSERT INTO `baseWord` VALUES (21, 'na', 'な', 'ナ', 'な', 'あ', '0');
INSERT INTO `baseWord` VALUES (22, 'ni', 'に', 'ニ', 'な', 'い', '0');
INSERT INTO `baseWord` VALUES (23, 'nu', 'ぬ', 'ヌ', 'な', 'う', '0');
INSERT INTO `baseWord` VALUES (24, 'ne', 'ね', 'ネ', 'な', 'え', '0');
INSERT INTO `baseWord` VALUES (25, 'no', 'の', 'ノ', 'な', 'お', '0');
INSERT INTO `baseWord` VALUES (26, 'ha', 'は', 'ハ', 'は', 'あ', '0');
INSERT INTO `baseWord` VALUES (27, 'hi', 'ひ', 'ヒ', 'は', 'い', '0');
INSERT INTO `baseWord` VALUES (28, 'hu', 'ふ', 'フ', 'は', 'う', '0');
INSERT INTO `baseWord` VALUES (29, 'he', 'へ', 'ヘ', 'は', 'え', '0');
INSERT INTO `baseWord` VALUES (30, 'ho', 'ほ', 'ホ', 'は', 'お', '0');
INSERT INTO `baseWord` VALUES (31, 'ma', 'ま', 'マ', 'ま', 'あ', '0');
INSERT INTO `baseWord` VALUES (32, 'mi', 'み', 'ミ', 'ま', 'い', '0');
INSERT INTO `baseWord` VALUES (33, 'mu', 'む', 'ム', 'ま', 'う', '0');
INSERT INTO `baseWord` VALUES (34, 'me', 'め', 'メ', 'ま', 'え', '0');
INSERT INTO `baseWord` VALUES (35, 'mo', 'も', 'モ', 'ま', 'お', '0');
INSERT INTO `baseWord` VALUES (36, 'ya', 'や', 'ヤ', 'や', 'あ', '0');
INSERT INTO `baseWord` VALUES (37, 'yu', 'ゆ', 'ユ', 'や', 'う', '0');
INSERT INTO `baseWord` VALUES (38, 'yo', 'よ', 'ヨ', 'や', 'お', '0');
INSERT INTO `baseWord` VALUES (39, 'ra', 'ら', 'ラ', 'ら', 'あ', '0');
INSERT INTO `baseWord` VALUES (40, 'ri', 'り', 'リ', 'ら', 'い', '0');
INSERT INTO `baseWord` VALUES (41, 'ru', 'る', 'ル', 'ら', 'う', '0');
INSERT INTO `baseWord` VALUES (42, 're', 'れ', 'レ', 'ら', 'え', '0');
INSERT INTO `baseWord` VALUES (43, 'ro', 'ろ', 'ロ', 'ら', 'お', '0');
INSERT INTO `baseWord` VALUES (44, 'wa', 'わ', 'ワ', 'わ', 'あ', '0');
INSERT INTO `baseWord` VALUES (45, 'wo', 'を', 'ヲ', 'わ', 'お', '0');
INSERT INTO `baseWord` VALUES (46, 'n', 'ん', 'ん', NULL, NULL, '9');
INSERT INTO `baseWord` VALUES (47, 'ga', 'が', 'ガ', 'が', 'あ', '1');
INSERT INTO `baseWord` VALUES (48, 'gi', 'ぎ', 'ギ', 'が', 'い', '1');
INSERT INTO `baseWord` VALUES (49, 'gu', 'ぐ', 'グ', 'が', 'う', '1');
INSERT INTO `baseWord` VALUES (50, 'ge', 'げ', 'ゲ', 'が', 'え', '1');
INSERT INTO `baseWord` VALUES (51, 'go', 'ご', 'ゴ', 'が', 'お', '1');
INSERT INTO `baseWord` VALUES (52, 'za', 'ざ', 'ザ', 'ざ', 'あ', '1');
INSERT INTO `baseWord` VALUES (53, 'ji', 'じ', 'ジ', 'ざ', 'い', '1');
INSERT INTO `baseWord` VALUES (54, 'zu', 'ず', 'ズ', 'ざ', 'う', '1');
INSERT INTO `baseWord` VALUES (55, 'ze', 'ぜ', 'ゼ', 'ざ', 'え', '1');
INSERT INTO `baseWord` VALUES (56, 'zo', 'ぞ', 'ゾ', 'ざ', 'お', '1');
INSERT INTO `baseWord` VALUES (57, 'da', 'だ', 'ダ', 'だ', 'あ', '1');
INSERT INTO `baseWord` VALUES (58, 'ji', 'ぢ', 'ヂ', 'だ', 'い', '1');
INSERT INTO `baseWord` VALUES (59, 'zu', 'づ', 'ヅ', 'だ', 'う', '1');
INSERT INTO `baseWord` VALUES (60, 'de', 'で', 'デ', 'だ', 'え', '1');
INSERT INTO `baseWord` VALUES (61, 'do', 'ど', 'ド', 'だ', 'お', '1');
INSERT INTO `baseWord` VALUES (62, 'ba', 'ば', 'バ', 'ば', 'あ', '1');
INSERT INTO `baseWord` VALUES (63, 'bi', 'び', 'ビ', 'ば', 'い', '1');
INSERT INTO `baseWord` VALUES (64, 'bu', 'ぶ', 'ブ', 'ば', 'う', '1');
INSERT INTO `baseWord` VALUES (65, 'be', 'べ', 'ベ', 'ば', 'え', '1');
INSERT INTO `baseWord` VALUES (66, 'bo', 'ぼ', 'ボ', 'ば', 'お', '1');
INSERT INTO `baseWord` VALUES (67, 'pa', 'ぱ', 'パ', 'ぱ', 'あ', '2');
INSERT INTO `baseWord` VALUES (68, 'pi', 'ぴ', 'ピ', 'ぱ', 'い', '2');
INSERT INTO `baseWord` VALUES (69, 'pu', 'ぷ', 'プ', 'ぱ', 'う', '2');
INSERT INTO `baseWord` VALUES (70, 'pe', 'ぺ', 'ペ', 'ぱ', 'え', '2');
INSERT INTO `baseWord` VALUES (71, 'po', 'ぽ', 'ポ', 'ぱ', 'お', '2');
INSERT INTO `baseWord` VALUES (72, 'kya', 'きゃ', 'キャ', 'き', 'ゃ', '3');
INSERT INTO `baseWord` VALUES (73, 'kyu', 'きゅ', 'キュ', 'き', 'ゅ', '3');
INSERT INTO `baseWord` VALUES (74, 'kyo', 'きょ', 'キョ', 'き', 'ょ', '3');
INSERT INTO `baseWord` VALUES (75, 'gya', 'ぎゃ', 'ギャ', 'ぎ', 'ゃ', '3');
INSERT INTO `baseWord` VALUES (76, 'gyu', 'ぎゅ', 'ギュ', 'ぎ', 'ゅ', '3');
INSERT INTO `baseWord` VALUES (77, 'gyo', 'ぎょ', 'ギョ', 'ぎ', 'ょ', '3');
INSERT INTO `baseWord` VALUES (78, 'sha', 'しゃ', 'シャ', 'し', 'ゃ', '3');
INSERT INTO `baseWord` VALUES (79, 'shu', 'しゅ', 'シュ', 'し', 'ゅ', '3');
INSERT INTO `baseWord` VALUES (80, 'sho', 'しょ', 'ショ', 'し', 'ょ', '3');
INSERT INTO `baseWord` VALUES (81, 'ja', 'じゃ', 'ジャ', 'じ', 'ゃ', '3');
INSERT INTO `baseWord` VALUES (82, 'ju', 'じゅ', 'ジュ', 'じ', 'ゅ', '3');
INSERT INTO `baseWord` VALUES (83, 'jo', 'じょ', 'ジョ', 'じ', 'ょ', '3');
INSERT INTO `baseWord` VALUES (84, 'cha', 'ちゃ', 'チャ', 'ち', 'ゃ', '3');
INSERT INTO `baseWord` VALUES (85, 'chu', 'ちゅ', 'チュ', 'ち', 'ゅ', '3');
INSERT INTO `baseWord` VALUES (86, 'cho', 'ちょ', 'チョ', 'ち', 'ょ', '3');
INSERT INTO `baseWord` VALUES (87, 'nya', 'にゃ', 'ニャ', 'に', 'ゃ', '3');
INSERT INTO `baseWord` VALUES (88, 'nyu', 'にゅ', 'ニュ', 'に', 'ゅ', '3');
INSERT INTO `baseWord` VALUES (89, 'nyo', 'にょ', 'ニョ', 'に', 'ょ', '3');
INSERT INTO `baseWord` VALUES (90, 'hya', 'ひゃ', 'ヒャ', 'ひ', 'ゃ', '3');
INSERT INTO `baseWord` VALUES (91, 'hyu', 'ひゅ', 'ヒュ', 'ひ', 'ゅ', '3');
INSERT INTO `baseWord` VALUES (92, 'hyo', 'ひょ', 'ヒョ', 'ひ', 'ょ', '3');
INSERT INTO `baseWord` VALUES (93, 'bya', 'ばゃ', 'ビャ', 'ば', 'ゃ', '3');
INSERT INTO `baseWord` VALUES (94, 'byu', 'ばゅ', 'ビュ', 'ば', 'ゅ', '3');
INSERT INTO `baseWord` VALUES (95, 'byo', 'ばょ', 'ビョ', 'ば', 'ょ', '3');
INSERT INTO `baseWord` VALUES (96, 'pya', 'ぱゃ', 'ピャ', 'ぱ', 'ゃ', '3');
INSERT INTO `baseWord` VALUES (97, 'pyu', 'ぱゅ', 'ピュ', 'ぱ', 'ゅ', '3');
INSERT INTO `baseWord` VALUES (98, 'pyo', 'ぱょ', 'ピョ', 'ぱ', 'ょ', '3');
INSERT INTO `baseWord` VALUES (99, 'mya', 'まゃ', 'ミャ', 'ま', 'ゃ', '3');
INSERT INTO `baseWord` VALUES (100, 'myu', 'まゅ', 'ミュ', 'ま', 'ゅ', '3');
INSERT INTO `baseWord` VALUES (101, 'myo', 'まょ', 'ミョ', 'ま', 'ょ', '3');
INSERT INTO `baseWord` VALUES (102, 'rya', 'らゃ', 'リャ', 'ら', 'ゃ', '3');
INSERT INTO `baseWord` VALUES (103, 'ryu', 'らゅ', 'リュ', 'ら', 'ゅ', '3');
INSERT INTO `baseWord` VALUES (104, 'ryo', 'らょ', 'リョ', 'ら', 'ょ', '3');

SET FOREIGN_KEY_CHECKS = 1;
