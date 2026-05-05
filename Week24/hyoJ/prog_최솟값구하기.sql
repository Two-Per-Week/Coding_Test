SELECT mcdp_cd AS "진료과코드", COUNT(mddr_id) AS "5월예약건수"
FROM appointment
WHERE TO_CHAR(apnt_ymd, 'YYYYmm') = '202205'
GROUP BY mcdp_cd
ORDER BY 2, 1
