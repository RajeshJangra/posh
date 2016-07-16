INSERT INTO CTR_BASKET_SALES_SUMM
VALUES ('2015-01-26', '0', 94, '18:39:46', 80719, '1010', 'BIG W Karrinyup', '', '', '', '', '', '', '', '', 'BIG W', '1000', 'Woolworths Ltd', 'WA', 'Western Australia', 'WA', 'AU', 1, 'ACTIVE', '1982-07-12', '2015-01-26', 1, 'In-Store', '38059383235', 3, '1000000000007583500', 21, '20150126586103272240', '20150126225329002009465795', 'N', 'N', 994, 4, 1, 0, 4, 5, 0, 5, 1, 0, 5, 50.45, 45.86, -3.00, -7.59, 0.00, 0.00, 50.45, 4.59, 0.00, -3.00, -3.00, 0.00, 0.00, 0.00, 0.00, '2015-04-29', '18:39:46', '2015-04-29', 4.0000, 3.00, 1.0000, 3.0000, 2.0000, 12.95, '2015-01-26 00:00:00');


INSERT INTO CTR_PROD_SALES_SUMM
VALUES ('2015-01-26', '5795', '279564-AA', 2, '22:53:29', 946, '1010', 'Test Store 5795', '', '', '', '', '', '', 'BWS', '1000', 'Woolworths Ltd', 'NSW', 'New South Wales', 'NSW', 'AU', 1, 'ACTIVE', '2010-06-24', '2015-08-13', 1, 'In-Store', 21, '9344402337663', '20150126586103272240', 'N', 'Y', 'N', 'N', 'N', 97, '9344402337663', '279564', 1, 'EA', 'EA', 1, 1, 1, 0, 1, 0, 0.0000, 11.95, 10.76, 13.98, -1.20, 21.21, 34.53, 10.00, 12.22, 12.43, 9.99, 1.95, 3.95, '2015-08-13', 0.25, 0.1300, 11.9500, 11.75);


INSERT INTO CTR_PROD_ARTICLE
VALUES ('279564-AA', '1010', '279564', 'VHS Tape', 'BWS', 'SKC CAMERA TAPE', 'SKC CAMERA TAPE EC4', 'SKC.CAMCORDER SKC.CA', 'VHS TAPE', 'EA', 15, '', 1, 'EA', 100.0000, 'MM', 63.0000, 'MM', 28.0000, 'MM', 176.4000, 'MM', 10.0000, 'G', 0.0000, 'G', '', '', '20', 'LIQUOR', '', '', '2012', 'ELECTRICAL', '', '', '2012275', 'RECORDING MEDIA', '', '', '201227504', 'BLANK VIDEO TAPE/AUD', '', '', '', '', '', '', '', '', '', '', 'Skc.camcorder', 0, '', '', 0, '', 1, 'EA', 0, '', 0, '', 0, '', 12.59, '', '', '', 0, 0, '', '', '', '', '', '', '', '', '', '', '2', '2015-01-26');


INSERT INTO CTR_SALES_REWARD_DETAIL
VALUES ('22:53:29', 37, '5795', 2, '2015-01-26', 946, '279564-AA', 3, '20150126586103272240', '1010', 'Test Store 5795', '', '', '', '', '', '', '', '', 'BWS', '1000', 'Woolworths Ltd', 'QLD', 'Queensland', 'QLD', 'AU', 1, 'ACTIVE', '1979-03-20', '2015-01-26', 1, 'In-Store', '9344402337663', 21, 'N', 'Y', 0, -2, 1, -0.23, 1, 3.27, 0, 1, 14, 0, '2015-08-09', '09:52:17', '2015-08-09', 121, 3, 22);


INSERT INTO CTR_SALES_TENDER_SUMM
VALUES ('2015-01-26', '5795', '22:53:29', 2, 946, '1010', 'Test Store 5795', '?', '?', '?', '?', '?', '?', '?', '?', 'BWS', '1000', 'Woolworths Ltd', 'QLD', 'Queensland', 'NSW', 'AU', 2, 'CLOSED', '2010-06-23', '2010-11-01', 'Y', 'N', 'Y', 'N', 'Y', 'N', 11.9600, 13.9500, 1.9500, 2.9500, 3.0950, 4.9500, 5.9500, 6.9500, 7.9500, 8.9500, 9.9500, 10.9500, 11.9500, 12.9500, 13.9500, 14.9500, 15.9500, 16.9500, 17.9500, 18.9500, 19.9500, 20.9500, 21.9500, 22.9500, 11.9600, 0.0400, 23.9500, 24.9500, 25.9500, '20150126586103272240');


INSERT INTO BM_LINE_ITEM
VALUES ('1000000000007583500', '20150126586103272240', '2015-01-26', '279564-AA', '2015-01-26', 1.00, 1.00, 0, 9.00);


INSERT INTO BM_BASKET
VALUES ('1000000000007583500', '20150126586103272240', '2015-01-26', '2015-01-26', 1.00, 1.00, 'Processed', 0, -1);

/**
********************************   Data for new test cases. This will return 3 rows for each Basket from Product Tables row  *********************************************************
*/

INSERT INTO CTR_BASKET_SALES_SUMM
VALUES ('2015-01-30', '0', 94, '18:39:46', 80719, '1010', 'BIG W Karrinyup', '', '', '', '', '', '', '', '', 'BIG W', '1000', 'Woolworths Ltd', 'WA', 'Western Australia', 'WA', 'AU', 1, 'ACTIVE', '1982-07-12', '2015-01-30', 1, 'In-Store', '38059383235', 3, '1000000000007583600', 21, '20150126586103272250', '20150130225329002009465795', 'N', 'N', 994, 4, 1, 0, 4, 5, 0, 5, 1, 0, 5, 50.45, 45.86, -3.00, -7.59, 0.00, 0.00, 50.45, 4.59, 0.00, -3.00, -3.00, 0.00, 0.00, 0.00, 0.00, '2015-04-29', '18:39:46', '2015-04-29', 4.0000, 3.00, 1.0000, 3.0000, 2.0000, 12.95, '2015-01-26 00:00:00');


INSERT INTO CTR_PROD_SALES_SUMM
VALUES ('2015-01-30', '5795', '279570-AA', 2, '22:53:29', 946, '1010', 'Test Store 5795', '', '', '', '', '', '', 'BWS', '1000', 'Woolworths Ltd', 'NSW', 'New South Wales', 'NSW', 'AU', 1, 'ACTIVE', '2010-06-24', '2015-08-13', 1, 'In-Store', 21, '9344402337663', '20150126586103272250', 'N', 'Y', 'N', 'N', 'N', 97, '9344402337663', '279564', 1, 'EA', 'EA', 1, 1, 1, 0, 1, 0, 0.0000, 11.95, 10.76, 13.98, -1.20, 21.21, 34.53, 10.00, 12.22, 12.43, 9.99, 1.95, 3.95, '2015-08-13', 0.25, 0.1300, 11.9500, 11.75);
INSERT INTO CTR_PROD_SALES_SUMM
VALUES ('2015-01-30', '5795', '279580-AA', 2, '22:53:29', 946, '1010', 'Test Store 5795', '', '', '', '', '', '', 'BWS', '1000', 'Woolworths Ltd', 'NSW', 'New South Wales', 'NSW', 'AU', 1, 'ACTIVE', '2010-06-24', '2015-08-13', 1, 'In-Store', 21, '9344402337663', '20150126586103272250', 'N', 'Y', 'N', 'N', 'N', 97, '9344402337663', '279564', 1, 'EA', 'EA', 1, 1, 1, 0, 1, 0, 0.0000, 12.95, 10.76, 13.98, -1.20, 21.21, 34.53, 10.00, 12.22, 12.43, 9.99, 1.95, 3.95, '2015-08-13', 0.35, 0.1300, 12.9500, 11.75);
INSERT INTO CTR_PROD_SALES_SUMM
VALUES ('2015-01-30', '5795', '279590-AA', 2, '22:53:29', 946, '1010', 'Test Store 5795', '', '', '', '', '', '', 'BWS', '1000', 'Woolworths Ltd', 'NSW', 'New South Wales', 'NSW', 'AU', 1, 'ACTIVE', '2010-06-24', '2015-08-13', 1, 'In-Store', 21, '9344402337663', '20150126586103272250', 'N', 'Y', 'N', 'N', 'N', 97, '9344402337663', '279564', 1, 'EA', 'EA', 1, 1, 1, 0, 1, 0, 0.0000, 13.95, 10.76, 13.98, -1.20, 21.21, 34.53, 10.00, 12.22, 12.43, 9.99, 1.95, 3.95, '2015-08-13', 0.45, 0.1300, 13.9500, 11.75);


INSERT INTO CTR_PROD_ARTICLE
VALUES ('279570-AA', '1010', '279564', 'VHS Tape', 'BWS', 'SKC CAMERA TAPE', 'SKC CAMERA TAPE EC4', 'SKC.CAMCORDER SKC.CA', 'VHS TAPE', 'EA', 15, '', 1, 'EA', 100.0000, 'MM', 63.0000, 'MM', 28.0000, 'MM', 176.4000, 'MM', 10.0000, 'G', 0.0000, 'G', '', '', '20', 'LIQUOR', '', '', '2012', 'ELECTRICAL', '', '', '2012275', 'RECORDING MEDIA', '', '', '201227504', 'BLANK VIDEO TAPE/AUD', '', '', '', '', '', '', '', '', '', '', 'Skc.camcorder', 0, '', '', 0, '', 1, 'EA', 0, '', 0, '', 0, '', 12.59, '', '', '', 0, 0, '', '', '', '', '', '', '', '', '', '', '2', '2015-01-30');
INSERT INTO CTR_PROD_ARTICLE
VALUES ('279580-AA', '1010', '279564', 'Gen Bday Card', 'BWS', 'SKC CAMERA TAPE', 'SKC CAMERA TAPE EC4', 'SKC.CAMCORDER SKC.CA', 'Gen Bday Card', 'EA', 15, '', 1, 'EA', 100.0000, 'MM', 63.0000, 'MM', 28.0000, 'MM', 176.4000, 'MM', 10.0000, 'G', 0.0000, 'G', '', '', '20', 'LIQUOR', '', '', '2012', 'ELECTRICAL', '', '', '2012275', 'RECORDING MEDIA', '', '', '201227504', 'BLANK VIDEO TAPE/AUD', '', '', '', '', '', '', '', '', '', '', 'Skc.camcorder', 0, '', '', 0, '', 1, 'EA', 0, '', 0, '', 0, '', 12.59, '', '', '', 0, 0, '', '', '', '', '', '', '', '', '', '', '2', '2015-01-30');
INSERT INTO CTR_PROD_ARTICLE
VALUES ('279590-AA', '1010', '279564', 'Warrnambool Cheddar', 'BWS', 'SKC CAMERA TAPE', 'SKC CAMERA TAPE EC4', 'SKC.CAMCORDER SKC.CA', 'Warrnambool Cheddar', 'EA', 15, '', 1, 'EA', 100.0000, 'MM', 63.0000, 'MM', 28.0000, 'MM', 176.4000, 'MM', 10.0000, 'G', 0.0000, 'G', '', '', '20', 'LIQUOR', '', '', '2012', 'ELECTRICAL', '', '', '2012275', 'RECORDING MEDIA', '', '', '201227504', 'BLANK VIDEO TAPE/AUD', '', '', '', '', '', '', '', '', '', '', 'Skc.camcorder', 0, '', '', 0, '', 1, 'EA', 0, '', 0, '', 0, '', 12.59, '', '', '', 0, 0, '', '', '', '', '', '', '', '', '', '', '2', '2015-01-30');


INSERT INTO CTR_SALES_REWARD_DETAIL
VALUES ('22:53:29', 37, '5795', 2, '2015-01-30', 946, '279570-AA', 3, '20150126586103272250', '1010', 'Test Store 5795', '', '', '', '', '', '', '', '', 'BWS', '1000', 'Woolworths Ltd', 'QLD', 'Queensland', 'QLD', 'AU', 1, 'ACTIVE', '1979-03-20', '2015-01-30', 1, 'In-Store', '9344402337663', 21, 'N', 'Y', 0, -2, 1, -0.23, 1, 3.27, 0, 1, 14, 0, '2015-08-09', '09:52:17', '2015-08-09', 121, 3, 22);
INSERT INTO CTR_SALES_REWARD_DETAIL
VALUES ('22:53:29', 37, '5795', 2, '2015-01-30', 946, '279580-AA', 3, '20150126586103272250', '1010', 'Test Store 5795', '', '', '', '', '', '', '', '', 'BWS', '1000', 'Woolworths Ltd', 'QLD', 'Queensland', 'QLD', 'AU', 1, 'ACTIVE', '1979-03-20', '2015-01-30', 1, 'In-Store', '9344402337663', 21, 'N', 'Y', 0, -2, 1, -0.23, 1, 3.27, 0, 1, 14, 0, '2015-08-09', '09:52:17', '2015-08-09', 121, 3, 22);
INSERT INTO CTR_SALES_REWARD_DETAIL
VALUES ('22:53:29', 37, '5795', 2, '2015-01-30', 946, '279590-AA', 3, '20150126586103272250', '1010', 'Test Store 5795', '', '', '', '', '', '', '', '', 'BWS', '1000', 'Woolworths Ltd', 'QLD', 'Queensland', 'QLD', 'AU', 1, 'ACTIVE', '1979-03-20', '2015-01-30', 1, 'In-Store', '9344402337663', 21, 'N', 'Y', 0, -2, 1, -0.23, 1, 3.27, 0, 1, 14, 0, '2015-08-09', '09:52:17', '2015-08-09', 121, 3, 22);


INSERT INTO CTR_SALES_TENDER_SUMM
VALUES ('2015-01-30', '5795', '22:53:29', 2, 946, '1010', 'Test Store 5795', '?', '?', '?', '?', '?', '?', '?', '?', 'BWS', '1000', 'Woolworths Ltd', 'QLD', 'Queensland', 'NSW', 'AU', 2, 'CLOSED', '2010-06-23', '2010-11-01', 'Y', 'N', 'Y', 'N', 'Y', 'N', 11.9600, 13.9500, 1.9500, 2.9500, 3.0950, 4.9500, 5.9500, 6.9500, 7.9500, 8.9500, 9.9500, 10.9500, 11.9500, 12.9500, 13.9500, 14.9500, 15.9500, 16.9500, 17.9500, 18.9500, 19.9500, 20.9500, 21.9500, 22.9500, 11.9600, 0.0400, 23.9500, 24.9500, 25.9500, '20150126586103272250');


INSERT INTO BM_LINE_ITEM
VALUES ('1000000000007583600', '20150126586103272250', '2015-01-30', '279570-AA', '2015-01-30', 1.00, 1.00, 0, 9.00);
INSERT INTO BM_LINE_ITEM
VALUES ('1000000000007583600', '20150126586103272250', '2015-01-30', '279580-AA', '2015-01-30', 1.00, 1.00, 0, 9.00);
INSERT INTO BM_LINE_ITEM
VALUES ('1000000000007583600', '20150126586103272250', '2015-01-30', '279590-AA', '2015-01-30', 1.00, 1.00, 0, 9.00);

INSERT INTO BM_BASKET
VALUES ('1000000000007583600', '20150126586103272250', '2015-01-30', '2015-01-30', 1.00, 1.00, 'Processed', 0, -1);



/**
Price Summary API Data
 */
INSERT INTO BM_BASKET
VALUES ('1000000000007588888', '20150902012732002014451777', '2015-01-26', '2015-01-26', 1.00, 1.00, 'Processed', 0, -1);
INSERT INTO BM_BASKET
VALUES ('1000000000007588888', '20150902012732002014451777', '2016-01-26', '2015-01-26', 1.00, 2.00, 'Processed', 0, -1);
INSERT INTO BM_BASKET
VALUES ('1000000000007588888', '20150902012732002014451777', '2017-01-26', '2015-01-26', 1.00, 3.00, 'Processed', 0, -1);

INSERT INTO BM_BASKET
VALUES ('1000000000007599999', '2015090201273200201445177', '2015-01-26', '2015-01-26', 1.00, 3.00, 'Processed', 0, -1);